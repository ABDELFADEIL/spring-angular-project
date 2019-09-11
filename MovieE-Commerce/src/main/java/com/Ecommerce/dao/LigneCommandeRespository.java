package com.Ecommerce.dao;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



public interface LigneCommandeRespository extends JpaRepository<LigneCommande, Long> {
	
	//     public Page<LigneCommande> findByCategoryIdCategory(@Param("idCategory")Long idCategory, Pageable pageable);
	  //public Page<LigneCommande> findByPanierId(@Param("idPanier")Long idPanier, Pageable pageable);
	 // public List<LigneCommande> findByPanierId(@Param("idPanier")Long idPanier);


	






}
