package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {

}
