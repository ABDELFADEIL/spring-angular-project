package com.Ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.Adresse;

@CrossOrigin("*")
@RepositoryRestResource
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
	
	public Adresse findByAppUser(@Param(value="id") Long id);


}
