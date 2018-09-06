package com.spring.boot.microservices.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User model description.")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
		
	@Size(min = 3, message = "At least 3 chars required.")
	@ApiModelProperty(notes = "At least 3 chars required.")
	private String name;
		
	@Past
	@ApiModelProperty(notes = "DateOfBirth should be past.")
	private LocalDateTime dob;
	
	public User() {}
	
	public User(Integer id, String name, LocalDateTime dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
