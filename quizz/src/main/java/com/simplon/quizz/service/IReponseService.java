package com.simplon.quizz.service;

import com.simplon.quizz.entities.Reponse;

import java.util.List;

public interface IReponseService {

    List<Reponse> getReponseParQuestionId(Long idQuestion);
    Reponse getReponse(Long id);
    Reponse addReponse(String textReponse, Long idReponse);
    Reponse updateReponse(String textReponse, Long idReponse);
    Reponse getBonneReponse(Long idQuestion);
    boolean deleteReponse(Long idReponse);
}
