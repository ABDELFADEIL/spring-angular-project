package com.example.demo.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.com.entities.AppUser;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<AppUser, Long> {
 
	public AppUser findByUsername(String username);
}
