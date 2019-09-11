package com.Ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;




public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	public Panier findByAppUserId(@Param("id") Long id);
   // public List<LigneCommande> findItemsById(@Param("id")Long id);
	
	//@Query("select a from Article a where a.category.idCategory=:idCategory")
		//public List<Article> searchByCategoryList(@Param("idCategory") Long idCategory);


}
