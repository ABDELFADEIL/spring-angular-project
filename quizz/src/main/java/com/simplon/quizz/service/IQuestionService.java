package com.simplon.quizz.service;

import com.simplon.quizz.entities.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> getQuestionsParQuizzId(Long idQuizz);
    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    boolean deleteQuestion(Long idQuestion);
}
