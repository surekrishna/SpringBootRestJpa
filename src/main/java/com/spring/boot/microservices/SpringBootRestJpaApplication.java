package com.spring.boot.microservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestJpaApplication.class, args);
	}
	
	
	@Bean
	public LocaleResolver localeResolver() {
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;		
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		var rbms = new ResourceBundleMessageSource();
		rbms.setBasename("messages");		
		return rbms;
	}
}
