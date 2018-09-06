package com.spring.boot.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservices.domain.LoginUser;
import com.spring.boot.microservices.exception.UserNotFoundException;
import com.spring.boot.microservices.service.FilterDaoService;

@RestController
public class FilteringBeanController {
	
	@Autowired
	private FilterDaoService filterDaoService;

	@GetMapping("/loginUser/{id}")
	public LoginUser getUser(@PathVariable int id) {		
		LoginUser user =  this.filterDaoService.getLoginUser(id);
		if(null == user) {
			throw new UserNotFoundException("id = "+id);
		}
		return user;
	}
	
	@GetMapping("/loginUsers")
	public List<LoginUser> getUserList(){
		List<LoginUser> loginList = this.filterDaoService.getLoginUserList();		
		if(loginList.isEmpty()) {
			throw new UserNotFoundException("No User exist, please add user to to get userlist.");
		}
		return loginList;
	}
}
