package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.entities.Category;

@CrossOrigin("https://localhost:4200/**")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@GetMapping("/getCategories")
	public Page<Category> getCategories(
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size	
			){
		return categoryRepository.findAll(new PageRequest(page, size));
	}

}
