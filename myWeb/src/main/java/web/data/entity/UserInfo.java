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
@Table(name="user_info")
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 3826076993492916439L;

	/**
	 * �ڵ����� primary Key
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * ��Email
	 */
	@Column(name="email", length=80)
	private String email;
	
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
