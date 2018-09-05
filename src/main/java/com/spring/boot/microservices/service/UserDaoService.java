package com.spring.boot.microservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.boot.microservices.domain.User;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();
	
	static {
		userList.add(new User(1,"John", LocalDateTime.now()));
		userList.add(new User(2,"Linda", LocalDateTime.now()));
		userList.add(new User(3,"Jack", LocalDateTime.now()));
	}
	
	public User getUser(int id) {
		for(var user: userList) {
			if(user.getId() == id) {
				return user;
			}					
		}
		return null;
	}
	
	public List<User> getUsers(){
		return userList;
	}
	
	public User saveUser(User user) {		
		if(null == user.getId()) {
			user.setId(userList.size() + 1);
		}		
		userList.add(user);
		return user;
	}
	
	public User deleteUserById(int id) {
		var user = new User();
		Iterator<User> itr = userList.iterator();		
		while(itr.hasNext()) {
			user = itr.next();
			if(user.getId() == id) {
				itr.remove();				
				return user;
			}
		}		
		return null;		
	}
}
