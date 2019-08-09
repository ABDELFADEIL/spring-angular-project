package com.example.demo.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.com.entities.AppRole;

import com.example.demo.com.entities.AppRole;

@RepositoryRestResource
@CrossOrigin("*")
public interface RoleRepository  extends JpaRepository<AppRole, Long>{
	
	public AppRole findByRoleName(String roleName);

}
