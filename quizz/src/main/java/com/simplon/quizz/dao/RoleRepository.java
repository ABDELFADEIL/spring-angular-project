package com.simplon.quizz.dao;

import com.simplon.quizz.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
