package com.spring.boot.microservices.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginUser {

	private int id;
	private String userName;	
	@JsonIgnore
	private String password;
	private boolean isActive;
	
	public LoginUser(){ }
	
	public LoginUser(int id, String userName, String password, boolean isActive) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", userName=" + userName + ", password=" + password + ", isActive=" + isActive
				+ "]";
	}
			
}
