package com.Ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article implements Serializable{


	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idArticle;
	private String name;
	private String description;
	private int quantity;
	private int price;
	private String photo;
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category category;	
	@ManyToOne
	private Commande commande;
	
}
