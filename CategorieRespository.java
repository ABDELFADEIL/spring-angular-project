package com.example.demo.com.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.com.entities.Categorie;
import com.example.demo.com.entities.Produit;

@RepositoryRestResource
@CrossOrigin("*")
public interface CategorieRespository extends JpaRepository<Categorie, Long>{
	
	

}
