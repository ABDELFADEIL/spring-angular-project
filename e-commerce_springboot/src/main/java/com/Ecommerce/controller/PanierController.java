package com.Ecommerce.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.ArticleRepository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;

@RestController
@CrossOrigin("*")
@RequestMapping("/panier")
public class PanierController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private PanierService panierService;
	
	
	
	@PostMapping(value = "/new-panier/{id}")
	public Panier CreatePanier(@PathVariable("id") Long id) 
	    {
		return panierService.CreatePanier(id);
		}
	
	@PostMapping(value = "/add/{id}")
	public LigneCommande AddArticlePanier(@PathVariable("id") Long id, @RequestBody LigneCommande ligneCommande)
	    {
		return panierService.AddArticlePanier(ligneCommande, id);
		}
	
	@PutMapping(value = "/update")
	public LigneCommande UpdateArticlePanier(@RequestBody LigneCommande lc)
	{
		return panierService.UpdateArticlePanier(lc);
	}
	

	@DeleteMapping(value = "/delete/{id}")
	public void DeleteArticlePanier(@PathVariable("id") Long id)
	    {
		 panierService.DeleteArticlePanier(id);
		}
	@GetMapping(value="/get/{id}")
	public LigneCommande getArticlePanier(@PathVariable("id") Long id) {
		return panierService.getArticlePanier(id);	
	}
	
	
	@GetMapping(value="/getAllArticlesList/{id}")
	public List<LigneCommande> getAllArticlesPanier(@PathVariable("id") Long id)
	    {
		return  (List<LigneCommande>) panierService.getAllArticlesPanier(id);
		} 
	
	@GetMapping(value="/getAllArticlesListPage/{id}")
	public Page<LigneCommande> getAllArticlesPanierPage(
			@PathVariable Long id,
			@RequestParam(name = "page", defaultValue="0") int page,
			@RequestParam(name = "size", defaultValue="10") int size
			)
	    {
		return  panierService.getAllPnierPage(id, new PageRequest(page,  size));
		} 
	
	@DeleteMapping(value="/deleteAllArticles/{id}")
	public void deleteAllArticlesPanier(@PathVariable("id") Long id) 
	        {
		 panierService.deleteAllArticlesPanier(id);
			}
	
	

}
