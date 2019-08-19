package com.Ecommerce.dao;

import com.Ecommerce.entities.LigneCommande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface LigneCommandeRespository extends JpaRepository<LigneCommande, Long> {

	






}
