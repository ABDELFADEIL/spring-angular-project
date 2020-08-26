package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {


    @Query("select reponse from Reponse reponse where reponse.question.id=:idQuestion")
    List<Reponse> findByQuestionId(Long idQuestion);
}
