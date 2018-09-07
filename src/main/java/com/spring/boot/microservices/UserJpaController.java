package com.spring.boot.microservices;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.microservices.dao.UserRepository;
import com.spring.boot.microservices.domain.Post;
import com.spring.boot.microservices.domain.User;
import com.spring.boot.microservices.exception.UserNotFoundException;

@RestController
public class UserJpaController {
		
	@Autowired
	private UserRepository userRepository; 

	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		Optional<User> user = this.userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id="+id);
		}else {			
			Resource<User> resource = new Resource<>(user.get());
			resource.add(linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users"));			
			return resource;
		}			
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User created = this.userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(created.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		this.userRepository.deleteById(id);		
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getPosts(@PathVariable int id) {
		Optional<User> user = this.userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id="+id);
		}									
			
		return user.get().getPosts();		
	}

}
