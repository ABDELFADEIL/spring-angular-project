package com.simplon.quizz.service;

import com.simplon.quizz.entities.Reponse;

import java.util.List;

public interface IReponseService {

    List<Reponse> getReponses(Long idQuestion);
    Reponse addResponse(String textReponse, Long idQuestion);
    List<Reponse> addReponses(String [] textReponse, Long idQuestion);
    Reponse updateReponse(Reponse reponse);
    boolean deleteReponse(Long idReponse);

}
