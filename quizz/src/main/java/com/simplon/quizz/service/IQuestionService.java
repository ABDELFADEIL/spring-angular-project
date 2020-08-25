package com.simplon.quizz.service;

import com.simplon.quizz.entities.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> getQuestionsParQuizzId(Long idQuizz);
    Question addQuestion(String textQuestion, Long idQuizz);
    Question updateQuestion(Question question);
    boolean deleteQuestion(Long idQuestion);
}
