package vmt.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * 
 * @author Kyle Lin
 * @see
 */
@Entity
@Table(name = "DEMO_USERS", schema = "KYLE_LIN")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_pk_generator")
	@SequenceGenerator(name = "user_pk_generator", sequenceName = "DEMO_USERS_PK_S", allocationSize = 1)
	@Column(name = "USER_ID", nullable = false)
	private Integer userSeq;

	@Column(name = "USER_NAME", nullable = false)
	private String userName;

	@Column(name = "PASSWD", nullable = false)
	private String password;

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}