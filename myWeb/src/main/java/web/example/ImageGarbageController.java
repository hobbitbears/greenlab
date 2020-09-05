package web.example;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import web.adapter.AsyncAdapter;
import web.data.entity.ImageGarbage;
import web.data.repogitory.ImageGarbageRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.time.ZonedDateTime;
import java.util.Properties;

@Slf4j
@RestController
@ConfigurationProperties("image.garbage")
@RequestMapping("/image/garbage")
public class ImageGarbageController {
    private static final Tika TIKA = new Tika();

    private final AsyncAdapter asyncAdapter;
    private final ImageGarbageRepository imageGarbageRepository;
    @Getter
    @Setter
    private Resource resource;

    public ImageGarbageController(AsyncAdapter asyncAdapter,
                                  ImageGarbageRepository imageGarbageRepository) {
        this.asyncAdapter = asyncAdapter;
        this.imageGarbageRepository = imageGarbageRepository;
    }

    @PostMapping
    public HttpEntity<Object> post(MultipartFile file, String name, UriComponentsBuilder builder){
        try (InputStream is = file.getInputStream()) {
            ZonedDateTime zonedDateTime = ZonedDateTime.now();
            byte[] byteArray = FileCopyUtils.copyToByteArray(is);
            String originalFilename = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(originalFilename);
            if (!StringUtils.hasText(extension)) {
                extension = MediaType.parseMediaType(file.getContentType()).getSubtype();
            }
            extension = MediaType.parseMediaType(TIKA.detect(byteArray, "file." + extension)).getSubtype();
            String filename = DigestUtils.md5DigestAsHex(("|" + zonedDateTime.toInstant().toEpochMilli() + "|" + originalFilename + "|").getBytes()) + "." + extension;

            Resource createRelative = resource.createRelative(zonedDateTime.getYear() + "/")
                    .createRelative(zonedDateTime.getMonthValue() + "/")
                    .createRelative(zonedDateTime.getDayOfMonth() + "/");

            String path = resource.getFile().getAbsoluteFile().toURI().relativize(createRelative.getFile().getAbsoluteFile().toURI()).getPath();

            Files.createDirectories(createRelative.getFile().toPath());
            asyncAdapter.resolve(() -> {
                try {
                    FileCopyUtils.copy(byteArray, createRelative.createRelative(filename).getFile());
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
                return null;
            });
            ImageGarbage imageGarbage = new ImageGarbage();
            imageGarbage.setName(name);
            imageGarbage.setPath(path);
            imageGarbage.setFilename(filename);
            imageGarbage.setOriginalFilename(originalFilename);
            log.info("image garbage: {}", imageGarbageRepository.save(imageGarbage));
            return ResponseEntity.created(builder.path(path + filename).build(new Object[0])).build();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
