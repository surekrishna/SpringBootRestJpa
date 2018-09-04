package com.spring.boot.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class SpringBootRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestJpaApplication.class, args);
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		var rbms = new ResourceBundleMessageSource();
		rbms.setBasename("messages");		
		return rbms;
	}
}
