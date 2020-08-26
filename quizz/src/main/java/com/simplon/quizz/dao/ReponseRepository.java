package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {

    List<Reponse> findByQuestionId(Long idQuestion);
}
