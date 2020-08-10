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
		tt.setTitle("���� ���������������");
		tt.setContent("Ǫ��������������������\n������������");
		int ret = newsService.saveNewsShort(tt);
		
		log.info("## NewsShortSaveTest : {}", ret);
	}

}
