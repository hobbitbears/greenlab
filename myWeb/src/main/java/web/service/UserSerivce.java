package web.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import web.data.entity.UserInfo;
import web.data.repogitory.UserInfoRepo;

/**
 * ������ ���� Serivce
 */
@Slf4j
@Service
public class UserSerivce {
	
	/**
	 * ��ƼƼ �޴���
	 */
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	/**
	 * �������� ����
	 * 
	 * @param userInfoForm �Է��� ����� ���� (������� Email)
	 * @return ���������� ��� ID��(���� ����) , �ƴѰ�� -1
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
