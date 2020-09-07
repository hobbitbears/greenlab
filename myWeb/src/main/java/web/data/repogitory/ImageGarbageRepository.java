package web.data.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;
import web.data.entity.ImageGarbage;

public interface ImageGarbageRepository extends JpaRepository<ImageGarbage, Long> {
}
