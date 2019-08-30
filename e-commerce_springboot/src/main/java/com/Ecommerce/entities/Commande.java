package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Commande implements Serializable{
	

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCommande;
	private String dateCommande;
	@OneToMany
	@JoinColumn(name="idCommande")
	@JsonIgnore
	private Collection<LigneCommande> ligneCommandes;
	 
	/*
	 * private Payement payement; private Livraison livraison;
	 */






	

}
