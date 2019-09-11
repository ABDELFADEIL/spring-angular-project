package com.Ecommerce.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Adresse implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="idUser")
	private AppUser appUser;
	private String Pays;
	private String Ville;
	private int codePostal;
	private String voie;
	private int NoVoie;
	private boolean active;
	
	
	
	
	
}
