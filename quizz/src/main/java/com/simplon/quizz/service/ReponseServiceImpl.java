package com.simplon.quizz.service;

import com.simplon.quizz.dao.ReponseRepository;
import com.simplon.quizz.entities.Reponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReponseServiceImpl implements IReponseService{

    private final transient ReponseRepository reponseRepository;


    public ReponseServiceImpl(ReponseRepository reponseRepository) {
        this.reponseRepository = reponseRepository;
    }


    @Override
    public List<Reponse> getReponses(Long idQuestion) {
        return reponseRepository.findByQuestionId(idQuestion);
    }

    @Override
    public Reponse addResponse(String textReponse, Long idQuestion) {
        return null;
    }

    @Override
    public List<Reponse> addReponses(String[] textReponse, Long idQuestion) {
        return null;
    }

    @Override
    public Reponse updateReponse(Reponse reponse) {
        return null;
    }

    @Override
    public boolean deleteReponse(Long idReponse) {
        return false;
    }
}
