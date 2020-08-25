package com.simplon.quizz.dao;

import com.simplon.quizz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {

}
