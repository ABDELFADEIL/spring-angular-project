package com.Ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.Panier;





public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	public Panier findByAppUser(@Param("id") Long id);
	
	//@Query("select p from Panier p where p.user.id=:id")
	//public Panier searchByUserId(@Param("id") Long id);

}
