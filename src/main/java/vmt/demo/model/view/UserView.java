package vmt.demo.model.view;

public class UserView {
	private String userId;
	private String password;

	public UserView(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public UserView() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
