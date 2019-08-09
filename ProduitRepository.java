package com.example.demo.com.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.com.entities.Categorie;
import com.example.demo.com.entities.Produit;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@RestResource(path="/porduitsByDescription")
	public Page<Produit> findByDescContains(@Param("mc") String mc, Pageable pageable); 

	@RestResource(path="/porduitsByCategory")
	public Page<Produit> findByCategorieId(@Param("id") Long id, Pageable pageable); 
	
	@RestResource(path="/porduitsByCategoryAndDescriotion")
	public Page<Produit> findByCategorieIdAndDescContains(@Param("id") Long id, @Param("mc") String mc, Pageable pageable);
}
