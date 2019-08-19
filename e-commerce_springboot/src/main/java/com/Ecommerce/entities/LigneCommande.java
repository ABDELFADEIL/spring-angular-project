package com.Ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneCommande {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idLigneCommande;
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	private int quantite;
	private double prix;

}
