package com.spring.boot.microservices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.microservices.exception.UserNotFoundException;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDaoService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		var user = userDaoService.getUser(id);
		
		if(null == user) {
			throw new UserNotFoundException("id="+id);
		}else {
			return user;
		}			
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User created = this.userDaoService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(created.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteUserById(id);
		
		if(null == user) {
			throw new UserNotFoundException("id="+id);
		}else {
			return "User id = "+id+" deleted Successfully.";
		}	
		
	}
	
}
