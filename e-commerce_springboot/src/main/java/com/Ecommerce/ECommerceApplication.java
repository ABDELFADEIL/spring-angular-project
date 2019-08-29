package com.Ecommerce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
import com.Ecommerce.service.PanierServiceImpl;
import com.Ecommerce.dao.AdresseRepository;
import com.Ecommerce.dao.ArticleRepository;
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
	private ArticleRepository articleRespository;
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
	private PanierServiceImpl panierService;
	@Autowired
	private LigneCommandeRespository ligneCommandeRespository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
		System.out.println("");
	}

	@Override
	public void run(String... args) throws Exception {

		
		  Adresse a1 = new Adresse(); Adresse a2 = new Adresse(); Adresse a3 = new
		  Adresse(); Adresse a4 = new Adresse(); Adresse a5 = new Adresse();
		  
		  a1.setPays("Italie"); a1.setVille("Rome"); a2.setPays("France");
		  a2.setVille("Paris"); a3.setPays("Soudan"); a3.setVille("Khartoum");
		  a4.setPays("Espagne"); a4.setVille("Madrid"); a5.setPays("Quatar");
		  a5.setVille("Doha");
		  
		  adresseRepository.save(a1); adresseRepository.save(a2);
		  adresseRepository.save(a3); adresseRepository.save(a4);
		  adresseRepository.save(a5);
		  
		  
		  Panier p1 = new Panier(); Panier p2 = new Panier(); Panier p3 = new Panier();
		  Panier p4 = new Panier(); Panier p5 = new Panier();
		  
		  panierRepository.save(p1); panierRepository.save(p2);
		  panierRepository.save(p3); panierRepository.save(p4);
		  panierRepository.save(p5);
		  
		  
		  
		  AppRole r1 = new AppRole(null, "USER"); AppRole r2 = new AppRole(null,
		  "ADMIN"); accountService.saveRole(r1); accountService.saveRole(r2);
		  
		  AppUser u1 = new AppUser(); AppUser u2 = new AppUser();
		  
		  u1.setUsername("admin"); u1.setPassword("1234"); u2.setUsername("user");
		  u2.setPassword("1234");
		  
		  accountService.saveUser(u1); accountService.saveUser(u2);
		  
		/*
		 * u1.getAdresses().add(a1); u1.getAdresses().add(a2); u1.getAdresses().add(a5);
		 * 
		 * u2.getAdresses().add(a3); u2.getAdresses().add(a4);
		 * 
		 * adresseRepository.save(a1); adresseRepository.save(a2);
		 * adresseRepository.save(a3); adresseRepository.save(a4);
		 * adresseRepository.save(a5);
		 */
		  
		  accountService.saveUser(u1); accountService.saveUser(u2);
		  
		  
		  accountService.addRoleToUser(u1.getUsername(), r1.getRoleName());
		  accountService.addRoleToUser(u1.getUsername(), r2.getRoleName());
		  accountService.addRoleToUser(u2.getUsername(), r2.getRoleName());
		  
		  
		  u1.setPanier(p1); u2.setPanier(p2);
		  
		  
		/* accountService.saveUser(u1); accountService.saveUser(u2); */
		  
		  Random rn = new Random();
		  
		  for (int i = 0; i < 3; i++) { Category c1 = new Category();
		  c1.setName(rn.toString()); c1.setDescription(rn.toString());
		  categoryRepository.save(c1);
		  
		  for (int x = 0; x < 10; x++) { Article a = new Article();
		  a.setName(rn.toString()); a.setDescription(rn.toString());
		  a.setPrice(rn.nextInt()*100); a.setQuantity(rn.nextInt()); a.setCategory(c1);
		  articleRespository.save(a);
		  
		  }
		  
		  }
		  
		  for (int i = 0; i < 10; i++) {
			
			  // panierService
			  LigneCommande lc1 = new LigneCommande();
			  lc1.setPrix(100);
			  lc1.setQuantite(99);
			  ligneCommandeRespository.save(lc1);
			  Article ar = new Article();
			  articleRespository.save(ar);
			  Article a = articleRespository.findOne(i+1L);
			  lc1.setArticle(a);
			  lc1.setPrix(452);
			 // lc1.setQuantite(854);
			  LigneCommande lc = panierService.AddArticlePanier(lc1, 1L);
		}
		  		  
		  //panierService.AddArticle(lc, 1L);
		  //System.out.println(lc.getIdLigneCommande() +" : "+lc.getPrix() +" : "+ lc.getQuantite());
		 // System.out.println(lc.getArticle().getIdArticle());
		  
		 List<LigneCommande> listPanier = (List<LigneCommande>) panierService.getAllArticlesPanier(1L);
		 
		 for (int i = 0; i < listPanier.size(); i++) {
			 System.out.println(listPanier.get(i).getIdLigneCommande() +" : "+listPanier.get(i).getPrix() +" : "+ listPanier.get(i).getQuantite());
			 System.out.println(listPanier.get(i).getArticle().getIdArticle());
		}
		 
		 //Collection<LigneCommande> list = panierService.getAllArticlesPanier(1L);
		// listPanier.removeAll(listPanier);
		 
		 //List<LigneCommande> listPanier2 = (List<LigneCommande>) panierService.getAllArticlesPanier(1L);
		 
		 System.out.println("Start deleting ...");
		 for (int i = 0; i < listPanier.size(); i++) {
			 System.out.println(listPanier.get(i).getIdLigneCommande() +" : "+listPanier.get(i).getPrix() +" : "+ listPanier.get(i).getQuantite());
			 System.out.println(listPanier.get(i).getArticle().getIdArticle());

		}
		 System.out.println("fin deleting ...");

		/*
		 * LigneCommande lc = panierService.getArticle(1L);
		 * 
		 * panierService.DeleteArtcle(lc.getIdLigneCommande());
		 */

		config.exposeIdsFor(Article.class, Category.class, Commande.class, Panier.class, AppUser.class);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean org.h2.tools.Server h2Server() { Server server = new Server(); try {
	 * server.runTool("-tcp"); server.runTool("-tcpAllowOthers"); } catch (Exception
	 * e) { e.printStackTrace(); } return server;
	 * 
	 * }
	 */
}
