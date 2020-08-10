package web.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import web.data.entity.UserInfo;
import web.data.repogitory.UserInfoRepo;

/**
 * 고객정보 관련 Serivce
 */
@Slf4j
@Service
public class UserSerivce {
	
	/**
	 * 엔티티 메니저
	 */
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	/**
	 * 고객정보를 저장
	 * 
	 * @param userInfoForm 입럭할 사용자 정보 (현재기준 Email)
	 * @return 정상저장의 경우 ID값(양의 정수) , 아닌경우 -1
	 */
	public int joinUserInfo(UserInfo userInfoForm) {
		
		userInfoForm = userInfoRepo.save(userInfoForm);
		if (userInfoForm.getId() != null) {
			log.error("joinUserInfo Save Error. {}", userInfoForm);
			return -1;
		}
		
		return userInfoForm.getId();
	}
}
