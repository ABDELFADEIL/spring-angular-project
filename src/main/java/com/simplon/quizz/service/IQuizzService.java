package com.simplon.quizz.service;

import com.simplon.quizz.entities.Difuculte;
import com.simplon.quizz.entities.Quizz;

public interface IQuizzService {
	
	public Quizz createQuizz(int duration , Long  diffId , Long catId );
	public boolean deleteQuizz(Long idQ);
	public Quizz updateQuizz ( Long idQ);
}
