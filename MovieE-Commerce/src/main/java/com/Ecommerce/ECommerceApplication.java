package com.Ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Ecommerce.entities.Adresse;
import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.AccountServiceImpl;
import com.Ecommerce.service.PanierService;
import com.Ecommerce.dao.AdresseRepository;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.dao.LigneCommandeRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration config;
	@Autowired
	private ArticleRespository articleRespository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private LigneCommandeRespository ligneCommandeRespository;
	@Autowired
	private PanierService panierService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	// @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ECommerceApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {

		  AppRole r1 = new AppRole(null, "ADMIN"); 
		  AppRole r2 = new AppRole(null, "USER");
		  accountService.saveRole(r1);
		  accountService.saveRole(r2);
		
		  AppUser u1 = new AppUser();
		  AppUser u2 = new AppUser();	
		
		  u1.setUsername("admin"); 
		  u1.setPassword(bCryptPasswordEncoder.encode("1234")); 
		  u2.setUsername("user");
		  u2.setPassword(bCryptPasswordEncoder.encode("1234"));
		  
		  accountService.saveUser(u1);
		  accountService.saveUser(u2);

		  accountService.addRoleToUser(u1.getUsername(), r1.getRoleName());
		  accountService.addRoleToUser(u1.getUsername(), r2.getRoleName());
		  accountService.addRoleToUser(u2.getUsername(), r2.getRoleName());
		  
		  u1.getAdresses().add(a1);
		  u1.getAdresses().add(a2);
		  u1.getAdresses().add(a5);
		  
		  u2.getAdresses().add(a3);
		  u2.getAdresses().add(a4);
		  
		  adresseRepository.save(a1);
		  adresseRepository.save(a2);
		  adresseRepository.save(a3);
		  adresseRepository.save(a4);
		  adresseRepository.save(a5);
		  
		  accountService.saveUser(u1); 
		  accountService.saveUser(u2);
		  
		config.exposeIdsFor(Article.class, Category.class, Commande.class, Panier.class, AppUser.class);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
