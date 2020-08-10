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
@Table(name="news_short")
public class NewsShort implements Serializable {
	
	private static final long serialVersionUID = 2371286951514520202L;

	/**
	 * �ڵ����� primary Key
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * ��� ����
	 */
	@Column(name="title", length=200)
	private String title;
	
	/**
	 * ��� ����
	 */
	@Column(name="content", length=2000)
	private String content;
	
	/**
	 * ������
	 */
	@Column(name="created")
	@CreatedDate
	private LocalDateTime created;
	
	/**
	 * ������
	 */
	@Column(name="modified")
	@UpdateTimestamp
	private LocalDateTime modified;
}
