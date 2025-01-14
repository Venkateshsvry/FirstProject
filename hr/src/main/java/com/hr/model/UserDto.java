package com.hr.model;

public class UserDto {
	private String userId;
	private String password;
	public UserDto() {
	
	}
	public UserDto(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
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
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", password=" + password + "]";
	}

}
