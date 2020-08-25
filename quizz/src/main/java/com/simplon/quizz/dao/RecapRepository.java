package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Recap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecapRepository extends JpaRepository<Recap, Long> {

}
