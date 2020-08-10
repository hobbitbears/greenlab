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
	 * 磊悼积己 primary Key
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 绊按Email
	 */
	@Column(name="email", length=80)
	private String email;
	
	/**
	 * 积己老
	 */
	@Column(name="created")
	@CreatedDate
	private LocalDateTime created;
	
	/**
	 * 荐沥老
	 */
	@Column(name="modified")
	@UpdateTimestamp
	private LocalDateTime modified;
}
