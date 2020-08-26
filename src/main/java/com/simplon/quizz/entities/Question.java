package com.simplon.quizz.entities;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String textQuestion;
	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	@JsonIgnore
	private Categorie categorie;
	
	@OneToMany
	private List<Reponse> reponses;
	
	@OneToOne
	private Reponse bonneReponse;

}
