package com.example.demo.com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie implements Serializable {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String desc;
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie", cascade = CascadeType.ALL)
	private Collection<Produit> produits = new ArrayList<>();
	
	
}
