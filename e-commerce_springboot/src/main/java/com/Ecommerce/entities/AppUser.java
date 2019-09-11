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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonRootName(value = "appUser")
public class AppUser implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JsonIgnore
	private Collection<AppRole> roles= new ArrayList<>();
	private String adresse;
	private String email;
	private String tel;
	@OneToMany(mappedBy="appUser")
	@JsonIgnore
	private Collection<Adresse> adresses = new ArrayList<>();
	@OneToOne(mappedBy="appUser", cascade= CascadeType.ALL)
	private Panier panier;
	
}
