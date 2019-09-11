package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
}
