package web.data.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import web.data.entity.NewsLong;

public interface NewsLongRepo extends JpaRepository<NewsLong, Integer>{
	
}
