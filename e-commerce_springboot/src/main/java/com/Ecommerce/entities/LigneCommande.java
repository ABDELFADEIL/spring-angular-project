package com.Ecommerce.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class LigneCommande implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idLigneCommande;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="idArticle")
	private Article article;
	private int quantite;
	private double prix;

}
