package com.simplon.quizz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.quizz.dao.CategorieRepository;
import com.simplon.quizz.dao.DifuculteRepository;
import com.simplon.quizz.dao.QuestionRepository;
import com.simplon.quizz.dao.QuizzRepository;
import com.simplon.quizz.entities.Categorie;
import com.simplon.quizz.entities.Difuculte;
import com.simplon.quizz.entities.Question;
import com.simplon.quizz.entities.Quizz;

@Service
public class QuizzServiceImpl implements IQuizzService{

	@Autowired
	private   QuestionRepository questionRepository ;
	
	@Autowired
	CategorieRepository catRepository;
	
	@Autowired
	DifuculteRepository diffRepository;
	
	@Autowired
	private QuizzRepository quizRepository ;
	
	@Override
	public Quizz createQuizz(int duration , Long  diffId , Long catId ) {
		// TODO Auto-generated method stub
		List<Question> allQuestions = questionRepository.findAll();
		
		Categorie catSelected = catRepository.findById(catId).get();
		Difuculte diff = diffRepository.findById(diffId).get();
		List<Question> givenQuestions = questionRepository.findByCategorie(catId);
		Collections.shuffle(givenQuestions);
		int tailleQuizz = 10 ; 

		Quizz quizz = new Quizz();
		quizz.setCategorie(catSelected);
		quizz.setDuration(duration);
		quizz.setDifuculte(diff);
		
		List<Question> randomQuestion = givenQuestions.subList(0, tailleQuizz);
		quizz.setQuizzQuestionInRandom(randomQuestion);
		
		return quizRepository.save(quizz);
		 
	}

	@Override
	public boolean deleteQuizz(Long idQ) {
		// TODO Auto-generated method stub
		Quizz quizz = quizRepository.findById(idQ).get();
		boolean delete = false ;
		
		if ( quizz != null) {
			quizRepository.delete(quizz);
			delete = true ;
			return delete ;
		}
		else 
		return delete;
	}

	@Override
	public Quizz updateQuizz(Long idQ ) {
		// TODO Auto-generated method stub
		Quizz quizz = quizRepository.findById(idQ).get();
		
		
		return null;
	}
}
