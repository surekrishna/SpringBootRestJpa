package com.spring.boot.microservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.boot.microservices.domain.LoginUser;

@Component
public class FilterDaoService {

	private static List<LoginUser> loginList = new ArrayList<>();
	
	static {
		loginList.add(new LoginUser(1,"krishna","sdjl#@#!$",true));
		loginList.add(new LoginUser(2,"Babu","lkj^^55",true));
		loginList.add(new LoginUser(3,"Sure","ioweur686$$",false));
	}
	
	public LoginUser getLoginUser(int id) {
		for(LoginUser user: loginList) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	public List<LoginUser> getLoginUserList(){
		if(!loginList.isEmpty()) {
			return loginList;
		}
		return null;
	}
	
}
