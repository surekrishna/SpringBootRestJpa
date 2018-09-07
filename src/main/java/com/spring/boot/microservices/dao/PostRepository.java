package com.spring.boot.microservices.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.boot.microservices.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

}
