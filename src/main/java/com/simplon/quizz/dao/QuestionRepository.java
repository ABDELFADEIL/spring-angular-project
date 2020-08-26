package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long> {

	 @Query( value =" select * "
	 		+" from question as q join categorie as c "
	 		+" on q.id_category = c.id " 
	 		+" where c.id = :id " , nativeQuery = true)
	 public List<Question> findByCategorie(@Param("id") Long idCat);
}
