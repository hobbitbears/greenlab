package web.data.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import web.data.entity.NewsShort;

public interface NewsShortRepo extends JpaRepository<NewsShort, Integer>{
	
}
