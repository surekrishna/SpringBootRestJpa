package com.spring.boot.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.microservices.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
