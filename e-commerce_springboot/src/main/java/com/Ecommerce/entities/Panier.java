package com.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Panier implements Serializable {


	@Id @GeneratedValue
	private Long idPannier;
	@OneToOne
	@JoinColumn(name="idAppUser")
	private AppUser user;
	private HashMap<Long, LigneCommande> items;
	
	public Panier(AppUser user) {
		super();
		this.user = user;
	}
	
	
	
//	@OneToMany(mappedBy = "pannier")
//	private Collection<Article> articles;

}
