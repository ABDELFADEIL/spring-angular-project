package com.simplon.quizz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.quizz.dao.CategorieRepository;
import com.simplon.quizz.entities.Categorie;

@Service
public class CategorieServiceImpl implements ICategorieService {

	@Autowired
	CategorieRepository categoryRepository;

	// recuperer liste de categories
	@Override
	public List<Categorie> findAllCategories() {
		return categoryRepository.findAll();
	}

	// ajouter une categories
	@Override
	public Categorie addCategorie(Categorie cat) {
		return categoryRepository.save(cat);
	}

	// supprimer une categorie
	@Override
	public boolean deleteCategorie(Long idCat) {
		Categorie catToDelete = categoryRepository.findById(idCat).get();
		boolean delete = false;
		if (catToDelete != null) {
			categoryRepository.delete(catToDelete);
			delete = true;
			return delete;
		} else
			return delete;
	}

	// modifier une categorie
	@Override
	public Categorie updateCategorie(Long idCat, String newName) {

		Categorie catToUpdate = categoryRepository.findById(idCat).get();
		if (catToUpdate != null) {
			catToUpdate.setName(newName);
			categoryRepository.save(catToUpdate);
		}
		return catToUpdate;
	}

	// recuperer une par son Id
	@Override
	public Categorie getCategorie(Long idCat) {
		Categorie cat = categoryRepository.findById(idCat).get();
		return cat;
	}

}