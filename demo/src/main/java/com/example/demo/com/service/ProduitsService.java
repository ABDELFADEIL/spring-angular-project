package com.example.demo.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.com.dao.CategorieRespository;
import com.example.demo.com.dao.ProduitRepository;
import com.example.demo.com.entities.Categorie;
import com.example.demo.com.entities.Produit;

@Service
public class ProduitsService {
	@Autowired
    private	ProduitRepository produitRespository;
    @Autowired
	private CategorieRespository categorieRespository;
    
    public Produit addProduitToCategory(Produit p, Categorie c) {
    	Produit p1 = produitRespository.findOne(p.getId());
    	categorieRespository.findOne(c.getId()).getProduits().add(p1);
    
    	return p1;
    }
	
	

}
