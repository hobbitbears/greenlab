package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import web.data.entity.NewsLong;
import web.data.entity.NewsShort;
import web.data.repogitory.NewsLongRepo;
import web.data.repogitory.NewsShortRepo;

/**
 * ������ ���� Serivce
 */
@Slf4j
@Service
public class NewsService {
	
	/**
	 * ��ҽ� Data Control
	 */
	@Autowired
	NewsLongRepo newsLongRepo;
	
	/**
	 * ª���ҽ� Data Control
	 */
	@Autowired
	NewsShortRepo newsShortRepo;
	
	
	
	/**
	 * ª���ҽ� ����
	 * 
	 * @param userInfoForm �Է��� ����� ���� (������� Email)
	 * @return ���������� ��� ID��(���� ����) , �ƴѰ�� -1
	 */
	public int saveNewsShort(NewsShort newsShort) {
		
		newsShort = newsShortRepo.save(newsShort);
		if (newsShort.getId() == null) {
			log.error("saveNewsShort Save Error. {}", newsShort);
			return -1;
		}
		
		return newsShort.getId();
	}
	
	
	/**
	 * ��ҽ� ����
	 * 
	 * @param userInfoForm �Է��� ����� ���� (������� Email)
	 * @return ���������� ��� ID��(���� ����) , �ƴѰ�� -1
	 */
	public int saveNewsLong(NewsLong newsLong) {
		
		newsLong = newsLongRepo.save(newsLong);
		if (newsLong.getId() != null) {
			log.error("saveNewsLong Save Error. {}", newsLong);
			return -1;
		}
		
		return newsLong.getId();
	}
}
