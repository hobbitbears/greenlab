package web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import web.data.entity.NewsShort;
import web.service.NewsService;

@SpringBootTest
@Slf4j
class NewsSerivceTest {

	@Autowired
	NewsService newsService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void NewsShortSaveTest() {
		NewsShort tt = new NewsShort();
		tt.setTitle("제목 랄랄랄라랄라라라라라");
		tt.setContent("푸르르르르르르르르르르\n라라라라라라라라라라라");
		int ret = newsService.saveNewsShort(tt);
		
		log.info("## NewsShortSaveTest : {}", ret);
	}

}
