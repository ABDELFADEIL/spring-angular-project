package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import com.Ecommerce.dao.ArticleRespository;

@CrossOrigin("https://localhost:4200/**")
@RestController
public class ArticleController {
	
	
	
	@Autowired
	private ArticleRespository articleRespository;

	@GetMapping("/get-articles")
	public Page<Article> getArticles(
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size
			) {
		return articleRespository.findAll(new PageRequest(page, size));
	}
	
	@GetMapping("/get-articles-pages")
	public Page<Article> getArticles(
			@RequestParam(name = "mc", value="") String mc,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size			
			) {
		return articleRespository.findByDescriptionContains(mc,new PageRequest(page, size));
	}
	
	@GetMapping("/get-articles-category/{id}")
	public Page<Article> getArticlesParCategory(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size			
			) {
		return articleRespository.findByCategoryIdCategory(id, new PageRequest(page, size));
	}
	
	@GetMapping("/articles-category-mc/{idCategory}")
	public Page<Article> getArticlesParCategoryMotCle(
			@PathVariable Long idCategory,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="15") int size,
			@RequestParam(name = "mc", value="") String mc
			) {
		return articleRespository.findByCategoryIdCategoryAndDescriptionContains(idCategory, mc, new PageRequest(page, size));
	}	
	
	@GetMapping("/get-article/{id}")
	public Article getArticle(@PathVariable Long id) {
		return articleRespository.getOne(id);
	}

	@PostMapping("/add-article")
	public Article save(@RequestBody Article a) {
		return articleRespository.save(a);
	}
	@DeleteMapping("/delete-article/{id}")
	public void deleteArticle(@PathVariable Long id) {
		articleRespository.deleteById(id);
	}
	
	@PutMapping("modifier-article")
	public Article modifierArticle(@RequestBody Article article) {
		Article a =	articleRespository.getOne(article.getIdArticle());
		a.setIdArticle(article.getIdArticle());
		a.setName(article.getName());
		a.setDescription(article.getDescription());
		a.setPrice(article.getPrice());
		a.setQuantity(article.getQuantity());
		a.setPhoto(article.getPhoto());
		a.setDisponible(article.isDisponible());
		//Category c = categoryRepository.findByName(article)
		return articleRespository.save(a);
	}

}
