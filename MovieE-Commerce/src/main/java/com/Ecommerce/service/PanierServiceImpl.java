package com.Ecommerce.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ecommerce.dao.AdresseRepository;
import com.Ecommerce.dao.ArticleRespository;
import com.Ecommerce.dao.CategoryRepository;
import com.Ecommerce.dao.LigneCommandeRespository;
import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.Article;
import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;

@Service
@javax.transaction.Transactional
public class PanierServiceImpl implements PanierService {

	
	@Autowired
	private ArticleRespository articleRespository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private LigneCommandeRespository ligneCommandeRespository;
	
	

	@Override
	public Panier CreatePanier(Long idUser) {
		Panier panier= new Panier();
		AppUser user = userRepository.getOne(idUser);
		Panier p= panierRepository.save(panier);
		p.setAppUser(user);
		return panierRepository.save(p);
	}

	@Override
	public LigneCommande AddArticlePanier( Long userId, Article a) {
		Panier p= panierRepository.getOne(userId);
		LigneCommande arCom = null;
		List<LigneCommande> artiles =(List<LigneCommande>) p.getItems();
		
		for (LigneCommande lc : artiles) {
			
			if(a==lc.getArticle())
			{
				lc.setQuantite(lc.getQuantite()+1);
			arCom =ligneCommandeRespository.save(lc);	
				
			}else {
				
				
				LigneCommande nArticle = new LigneCommande();
				nArticle.setQuantite(1);
				LigneCommande ar=ligneCommandeRespository.save(nArticle);
				ar.setArticle(a);
				p.getItems().add(ar);
				arCom =ligneCommandeRespository.save(nArticle);	
			}
			
		}
		return arCom;
	}

	@Override
	public void DeleteArticlePanier(Long idArticle) {
		LigneCommande lc =ligneCommandeRespository.getOne(idArticle);
		if(lc.getQuantite() == 1) {
			ligneCommandeRespository.deleteById(idArticle);
		}
		else if(lc.getQuantite() > 1){	
			int q = lc.getQuantite()- 1;
			lc.setQuantite(q);
			ligneCommandeRespository.save(lc);
		}else {
			
		}

	}

	@Override
	public LigneCommande UpdateArticlePanier(LigneCommande article) {
		return	ligneCommandeRespository.save(article);
	}

	@Override
	public LigneCommande getArticlePanier(Long id) {
		return ligneCommandeRespository.getOne(id);
		
	}

	@Override
	public Collection<LigneCommande> getAllArticlesPanier(Long idPanier) {
		Panier p = panierRepository.getOne(idPanier);
		return  p.getItems();
		
				}
	
	@Override
	public void deleteAllArticlesPanier(Long idPanier) {
		Panier p = panierRepository.getOne(idPanier);
		Collection articles = p.getItems();
		articles.removeAll(articles);
		
				}

	@Override
	public Page<LigneCommande> getAllPanierPage(Long id, Pageable pageable) {
		Panier p = panierRepository.getOne(id);
		List<LigneCommande> list = (List<LigneCommande>) p.getItems();
		Page<LigneCommande> pages = new PageImpl<LigneCommande>(list, pageable, list.size());
		return pages;
	}


	
	
	
	


}
