package com.spring.boot.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.boot.microservices.domain.LoginUser;
import com.spring.boot.microservices.exception.UserNotFoundException;
import com.spring.boot.microservices.service.FilterDaoService;

@RestController
public class FilteringBeanController {
	
	@Autowired
	private FilterDaoService filterDaoService;

	@GetMapping("/loginUser/{id}")
	public MappingJacksonValue getUser(@PathVariable int id) {		
		LoginUser user =  this.filterDaoService.getLoginUser(id);
		if(null == user) {
			throw new UserNotFoundException("id = "+id);
		}
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","status");
		FilterProvider filters = new SimpleFilterProvider().addFilter("LoginUserFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/loginUsers")
	public MappingJacksonValue getUserList(){
		List<LoginUser> loginList = this.filterDaoService.getLoginUserList();		
		if(loginList.isEmpty()) {
			throw new UserNotFoundException("No User exist, please add user to to get userlist.");
		}
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","userName","status");
		FilterProvider filters = new SimpleFilterProvider().addFilter("LoginUserFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(loginList);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
