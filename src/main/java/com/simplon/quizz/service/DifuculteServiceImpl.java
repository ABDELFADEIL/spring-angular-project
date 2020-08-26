package com.simplon.quizz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.quizz.dao.DifuculteRepository;
import com.simplon.quizz.entities.Difuculte;

@Service
public class DifuculteServiceImpl {

	
	@Autowired
	DifuculteRepository diffRepository ;
	
	public List<Difuculte> listDifuculte(){
		return diffRepository.findAll();
	}
}
