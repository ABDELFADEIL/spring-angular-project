package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzRepository extends JpaRepository<Quizz, Long> {

}
