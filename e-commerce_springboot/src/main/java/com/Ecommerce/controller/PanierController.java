package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Ecommerce.dao.ArticleRepository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.service.AccountService;

@Controller
public class PanierController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private PanierRepository panierRepository;
	private LigneCommande cl;
	
	private AppUser u;
	
	@PostMapping(value = "/new-panier/{id}")
	public void postMethodName(@PathVariable("id") Long id) {
		//u = userRepository.findOne(id);
		panierRepository.save( new Panier());
		
			}

	
	
	
	

}
