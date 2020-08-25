package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Long> {

}
