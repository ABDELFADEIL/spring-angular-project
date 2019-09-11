package com.Ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.AppRole;



public interface RoleRepository extends JpaRepository<AppRole, Long> {

	public AppRole findByRoleName(String roleName);

}
