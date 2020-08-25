package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
