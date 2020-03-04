package vmt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_USERS")
public class User {

	@Id
	@Column(name = "USER_ID")
	private Integer userSeq;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWD")
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