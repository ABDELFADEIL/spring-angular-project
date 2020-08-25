package com.simplon.quizz.service;

import com.simplon.quizz.dao.QuestionRepository;
import com.simplon.quizz.entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {


    private final transient QuestionRepository questionRepository;


    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Question> getQuestionsParQuizzId(Long idQuizz) {
        return null;
    }

    @Override
    public Question addQuestion(Question question) {
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    public boolean deleteQuestion(Long idQuestion) {
        return false;
    }
}
