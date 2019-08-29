package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<AppRole> roles= new ArrayList<>();
	private String adresse;
	private String email;
	private String tel;
	@OneToMany(mappedBy="appUser")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Adresse> adresses = new ArrayList<>();
	@OneToOne(mappedBy="appUser")
	private Panier panier;
	
}
