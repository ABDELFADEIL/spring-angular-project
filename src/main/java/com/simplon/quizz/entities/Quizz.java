package com.simplon.quizz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Quizz implements Serializable {

	 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	@JsonIgnore
	private Categorie categorie;
	
	private int duration;
	
	
	private Difuculte difuculte;
	
	@ManyToMany
    @JoinTable(
          name="quizz_questions_random", schema = "public",
          joinColumns=@JoinColumn(name="quizz_id", referencedColumnName="id"),
          inverseJoinColumns=@JoinColumn(name="question_id", referencedColumnName="id"))
	private List<Question> quizzQuestionInRandom;

	 
	
}
