package com.demo.model.view;

public class UserView {
	private int userId;
	private String password;

	public UserView(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public UserView() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
