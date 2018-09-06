package com.spring.boot.microservices.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("LoginUserFilter") //Dynamic Filter
public class LoginUser {

	private int id;
	private String userName;	
	//@JsonIgnore //Static Filter
	private String password;
	private boolean status;
	
	public LoginUser(){ }

	public LoginUser(int id, String userName, String password, boolean status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", userName=" + userName + ", password=" + password + ", status=" + status + "]";
	}
				
}
