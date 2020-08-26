package com.simplon.quizz.service;

import com.simplon.quizz.dao.CategorieRepository;
import com.simplon.quizz.dao.QuestionRepository;
import com.simplon.quizz.entities.Categorie;
import com.simplon.quizz.entities.Question;
import com.simplon.quizz.dao.QuizzRepository;
import com.simplon.quizz.entities.Question;
import com.simplon.quizz.entities.Quizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	CategorieRepository catRepository ;
	@Override
	public List<Question> getQuestionsParQuizzId(Long idQuizz) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Question addQuestion(String textQuestion  , Long categorieId  ) {
		// TODO Auto-generated method stub
		Question question = new Question();
		Categorie cat = catRepository.findById(categorieId).get();
		question.setTextQuestion(textQuestion);
		question.setCategorie(cat);
		questionRepository.save(question);
		return question;
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteQuestion(Long idQuestion) {
		// TODO Auto-generated method stub
		return false;
	}


     
}
