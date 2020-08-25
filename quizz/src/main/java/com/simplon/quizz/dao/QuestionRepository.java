package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    public List<Question> findByQuizzId(@Param("id") Long id);

}
