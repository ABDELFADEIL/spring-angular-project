package com.Ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;



public interface CategoryRepository extends JpaRepository<Category, Long>{


}
