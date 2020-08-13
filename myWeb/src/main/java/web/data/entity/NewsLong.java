package web.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name="news_long")
public class NewsLong implements Serializable {
	
	private static final long serialVersionUID = 3424178735440675007L;

	/**
	 * 자동생성 primary Key
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 기사 제목
	 */
	@Column(name="title", length=200)
	private String title;
	
	/**
	 * 기사 대표 이미지
	 */
	@Column(name="title_image", length=200)
	private String titleImage;
	
	/**
	 * 기사 내용
	 */
	@Column(name="content", length=4000)
	private String content;
	
	/**
	 * 생성일
	 */
	@Column(name="created")
	@CreatedDate
	private LocalDateTime created;
	
	/**
	 * 수정일
	 */
	@Column(name="modified")
	@UpdateTimestamp
	private LocalDateTime modified;
}
