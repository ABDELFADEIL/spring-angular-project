package com.simplon.quizz.service;

import java.util.List;

import com.simplon.quizz.entities.Categorie;

public interface ICategorieService {
	
	
	public List<Categorie> findAllCategories();
	public Categorie addCategorie(Categorie cat);
	public boolean deleteCategorie(Long idCat);
	public Categorie updateCategorie(Long idCat, String newType);
	public Categorie getCategorie(Long idCat) ;
}
