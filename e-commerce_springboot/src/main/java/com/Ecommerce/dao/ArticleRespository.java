package com.Ecommerce.dao;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ArticleRespository extends JpaRepository<Article, Long> {

	
	//public Page<Article> findByUser(@Param("id") Long id, Pageable pageable);
   
    
	//@Query("select a from Article a where a.category.idCategory=:idCategory")
	//public List<Article> searchByCategoryList(@Param("idCategory") Long idCategory);
	//@Query("select a from Article a where a.category.idCategory=:idCategory")
	//public Page<Article> searchByCategoryBage(@Param("idCategory") Long idCategory, Pageable pageable); 
	//@Query("select a from Article a where a.category.idCategory like:idCategory and a.description like:mc")
	//public Page<Article> findByCategoryAndDescriptionContains(Category category, @Param("mc") String mc, Pageable pageable);
	
	public Page<Article> findByDescriptionContains(@Param("mc") String mc, Pageable pageable);
    public Page<Article> findByCategoryIdCategory(@Param("idCategory")Long idCategory, Pageable pageable);
	public Page<Article> findByCategoryIdCategoryAndDescriptionContains(@Param("idCategory")Long idCategory, @Param("mc") String mc, Pageable pageable);






}
