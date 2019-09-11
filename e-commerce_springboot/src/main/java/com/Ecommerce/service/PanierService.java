package com.Ecommerce.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Ecommerce.entities.LigneCommande;
import com.Ecommerce.entities.Panier;


public interface PanierService {

	public Panier CreatePanier(Long idUser);
	public LigneCommande  AddArticlePanier(LigneCommande article, Long idPanier);
	public void DeleteArticlePanier(Long idArticle);
	public LigneCommande UpdateArticlePanier(LigneCommande article);
	public LigneCommande getArticlePanier(Long id);
	public void deleteAllArticlesPanier(Long idPanier);
	public Collection<LigneCommande>  getAllArticlesPanier(Long idPanier);
    public Page<LigneCommande> getAllPnierPage(Long id, Pageable pageable);
}
