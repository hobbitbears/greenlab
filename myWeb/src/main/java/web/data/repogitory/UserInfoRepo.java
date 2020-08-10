package web.data.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import web.data.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{
	
}
