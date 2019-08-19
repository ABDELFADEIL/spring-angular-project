package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entities.Article;
import com.Ecommerce.dao.ArticleRespository;

//@CrossOrigin("*")
//@RestController
public class ArticleController {
//    @Autowired
//	private ArticleRespository articleRespository;
//    
//    @GetMapping("/articles/")
//    public List<Article> getArticles(){
//    	return articleRespository.findAll();
//    }
//    @PostMapping("/articles")
//    public Article save(@RequestBody Article a) {
//    	return articleRespository.save(a);
//    }
    
}
