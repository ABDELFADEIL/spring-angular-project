package com.simplon.quizz.service;

import com.simplon.quizz.dao.QuestionRepository;
import com.simplon.quizz.dao.QuizzRepository;
import com.simplon.quizz.entities.Question;
import com.simplon.quizz.entities.Quizz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {


    private final transient QuestionRepository questionRepository;
    private final transient QuizzRepository quizzRepository;


    public QuestionServiceImpl(QuestionRepository questionRepository, QuizzRepository quizzRepository) {
        this.questionRepository = questionRepository;
        this.quizzRepository = quizzRepository;
    }


    @Override
    public List<Question> getQuestionsParQuizzId(Long idQuizz) {
        return questionRepository.findByQuizzId(idQuizz);
    }

    @Override
    public Question addQuestion(String textQuestion, Long idQuizz) {
        Quizz quizz = quizzRepository.findById(idQuizz).get();
        Question question = new Question();
        question.setTextQuestion(textQuestion);
        question.setQuizz(quizz);
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public boolean deleteQuestion(Long idQuestion) {
        try {
            questionRepository.deleteById(idQuestion);
        } catch (Exception e){
            e.getStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Question getQuestion(Long idQuestion) {
        return questionRepository.findById(idQuestion).get();
    }
}
