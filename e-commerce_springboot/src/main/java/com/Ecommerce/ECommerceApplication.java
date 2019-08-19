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
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.Category;
import com.Ecommerce.entities.Commande;
import com.Ecommerce.entities.Pannier;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.AccountServiceImpl;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner{

	
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
	
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 * AppRole r1 = new AppRole(null,"USER"); AppRole r2 = new
		 * AppRole(null,"ADMIN"); //roleRepository.save(r1); //roleRepository.save(r2);
		 * 
		 * 
		 * AppUser u1 = new AppUser(null,"user","1234", null); AppUser u2 = new
		 * AppUser(null,"admin","1234", null); //
		 * u1.setPassword(bCryptPasswordEncoder.encode(u1.getPassword())); //
		 * u2.setPassword(bCryptPasswordEncoder.encode(u2.getPassword())); //
		 * userRepository.save(u2);
		 * 
		 * 
		 * 
		 * 
		 * accountService.addRoleToUser(u1.getUsername(), r1.getRoleName());
		 * accountService.addRoleToUser(u2.getUsername(), r2.getRoleName());
		 * accountService.addRoleToUser(u2.getUsername(), r2.getRoleName());
		 */
		 
		//  articleRespository.findAll().forEach(a-> { System.out.println(a); });
		 
		
		
		 // List<Article> liste= new ArrayList<>();
		
		/*
		 * Random rn = new Random();
		 * 
		 * 
		 * 
		 * for (int i = 0; i < 3; i++) { Category c1 = new Category();
		 * c1.setName(rn.toString()); c1.setDescription(rn.toString());
		 * categoryRepository.save(c1);
		 * 
		 * for (int x = 0; x < 10; x++) { Article a = new Article();
		 * a.setName(rn.toString()); a.setDescription(rn.toString());
		 * a.setPrice(rn.nextInt()*100); a.setQuantity(rn.nextInt()); a.setCategory(c1);
		 * articleRespository.save(a);
		 * 
		 * } //liste = articleRespository.findByCategory(c1);
		 * 
		 * }
		 */
		  
		  
		  
		
		/*
		 * Category c1 = categoryRepository.findOne(1L); List<Article> liste1= new
		 * ArrayList<>(); Category c = categoryRepository.findOne(8L); liste1 =
		 * articleRespository.findByCategory(c);
		 * 
		 * for (Article article : liste1) {
		 * 
		 * System.out.println(article.getIdArticle()); }
		 */
		 
		
			
		  config.exposeIdsFor(Article.class, Category.class, Commande.class, Pannier.class,  AppUser.class);
		}

		  @Bean
			public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
			}
}
