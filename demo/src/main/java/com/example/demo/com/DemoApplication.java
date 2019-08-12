package com.example.demo.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.com.dao.CategorieRespository;
import com.example.demo.com.dao.ProduitRepository;
import com.example.demo.com.entities.AppRole;
import com.example.demo.com.entities.AppUser;
import com.example.demo.com.entities.Categorie;
import com.example.demo.com.entities.Pannier;
import com.example.demo.com.entities.Produit;
import com.example.demo.com.entities.UserForm;
import com.example.demo.com.service.AccountService;
import com.example.demo.com.service.ProduitsService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableTransactionManagement
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRespository;
	@Autowired
	private CategorieRespository categorieRespository;
	@Autowired
	private ProduitsService produitService;
	@Autowired
	private RepositoryRestConfiguration config;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Pannier.class, Produit.class, Categorie.class, AppRole.class,  AppUser.class);

		/*
		 * AppRole r1 = new AppRole(null, "USER"); AppRole r2 = new AppRole(null,
		 * "ADMIN"); accountService.saveRole(r1); accountService.saveRole(r2);
		 * 
		 * AppUser appUser = new AppUser(); appUser.setUsername("admin");
		 * appUser.setPassword("1234"); //appUser.getRoles().add(r1);
		 * //appUser.getRoles().add(r2); accountService.saveUser(appUser);
		 * accountService.addRoleToUser("admin", "USER");
		 * accountService.addRoleToUser("admin", "ADMIN");
		 * 
		 * 
		 * Categorie c = new Categorie(); c.setDesc("categorie 1");
		 * categorieRespository.save(c);
		 * 
		 * for (int i = 0; i < 10; i++) { Produit p = new Produit();
		 * p.setName("Smart Tv SAMSUNG");
		 * p.setDesc("Smart Tv SAMSUNG 41' UHD model 2500"); p.setCategorie(c);
		 * p.setPhotoName("DVD_ROCK"); produitRespository.save(p);
		 * 
		 * }
		 * 
		 * Categorie c2 = new Categorie(); c.setDesc("categorie 1");
		 * categorieRespository.save(c2); categorieRespository.save(c); for (int i = 0;
		 * i < 10; i++) { Produit p = new Produit(); p.setName("Smart Tv Sonny");
		 * p.setDesc("Smart Tv Sonny 50' Full hd model 3010"); p.setCategorie(c2);
		 * p.setPhotoName("DVD_ROCK"); produitRespository.save(p);
		 * 
		 * }
		 */
		
		/*
		 * AppRole r1 = new AppRole(null, "USER"); AppRole r2 = new AppRole(null,
		 * "ADMIN"); accountService.saveRole(r1); accountService.saveRole(r2);
		 * 
		 * 
		 * 
		 * AppUser appUser = new AppUser(); appUser.setUsername("admin");
		 * appUser.setPassword("1234"); // appUser.getRoles().add(r1); //
		 * appUser.getRoles().add(r2); accountService.saveUser(appUser);
		 * accountService.addRoleToUser("admin", "USER");
		 * accountService.addRoleToUser("admin", "ADMIN");
		 * 
		 * 
		 * Categorie c = new Categorie(); c.setDesc("categorie 1");
		 * categorieRespository.save(c);
		 * 
		 * for (int i = 0; i < 10; i++) { Produit p = new Produit();
		 * p.setName("Smart Tv SAMSUNG");
		 * p.setDesc("Smart Tv SAMSUNG 41' UHD model 2500"); p.setCategorie(c);
		 * p.setPhotoName("DVD_ROCK"); produitRespository.save(p);
		 * 
		 * }
		 * 
		 * Categorie c2 = new Categorie(); c.setDesc("categorie 1");
		 * categorieRespository.save(c2); categorieRespository.save(c); for (int i = 0;
		 * i < 10; i++) { Produit p = new Produit(); p.setName("Smart Tv Sonny");
		 * p.setDesc("Smart Tv Sonny 50' Full hd model 3010"); p.setCategorie(c2);
		 * p.setPhotoName("DVD_ROCK"); produitRespository.save(p);
		 * 
		 * }
		 */
		 
		
		/*
		 * List<Produit> produits = produitRespository.findAll();
		 * 
		 * for (Produit produit : produits) { System.out.println(produit.toString()); }
		 */
		 
	}

	 @Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		}
}
