package com.simplon.quizz.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
// @Getter @Setter
public class Question implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String textQuestion;
    @ManyToOne
    @JoinColumn(name="idQuizz")
    private Quizz quizz;
    @OneToMany(mappedBy = "question")
    private List<Reponse> reponses = new ArrayList<>();

}
