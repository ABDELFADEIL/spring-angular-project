package com.simplon.quizz.service;

import com.simplon.quizz.dao.QuestionRepository;
import com.simplon.quizz.dao.ReponseRepository;
import com.simplon.quizz.entities.Question;
import com.simplon.quizz.entities.Reponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReponseServiceImpl implements IReponseService{

    private final transient ReponseRepository reponseRepository;
    private final transient QuestionRepository questionRepository;

    public ReponseServiceImpl(ReponseRepository reponseRepository, QuestionRepository questionRepository) {
        this.reponseRepository = reponseRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Reponse> getReponseParQuestionId(Long idQuestion) {
        return reponseRepository.findByQuestionId(idQuestion);
    }

    @Override
    public Reponse getReponse(Long id) {
        return reponseRepository.getOne(id);
    }

    @Override
    public Reponse addReponse(String textReponse, Long idReponse) {
        Reponse reponse = new Reponse();
        Question question = questionRepository.findById(idReponse).get();
        reponse.setTextDeReponse(textReponse);
        reponse.setQuestion(question);
        return reponseRepository.save(reponse);
    }

    @Override
    public Reponse updateReponse(String textReponse, Long idReponse) {
        Reponse reponse = reponseRepository.findById(idReponse).get();
        reponse.setTextDeReponse(textReponse);
        return reponseRepository.save(reponse);
    }

    @Override
    public Reponse getBonneReponse(Long idQuestion) {
        List<Reponse> reponseList = reponseRepository.findByQuestionId(idQuestion);
        Reponse bonne = null;
        for(Reponse response : reponseList) {
            if (response.getType() == "bonne"){
                bonne = response;
            }
        }
        return bonne;
    }

    @Override
    public boolean deleteReponse(Long idReponse) {
        try {
            Reponse reponse = reponseRepository.findById(idReponse).get();
            reponseRepository.delete(reponse);
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
        return true;
    }
}
