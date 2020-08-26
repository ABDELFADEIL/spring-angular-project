package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	Categorie findByName(String name);

}
