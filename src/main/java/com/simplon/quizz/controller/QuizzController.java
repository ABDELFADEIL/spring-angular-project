package com.simplon.quizz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.quizz.entities.Difuculte;
import com.simplon.quizz.entities.Quizz;
import com.simplon.quizz.service.IQuestionService;
import com.simplon.quizz.service.IQuizzService;

import net.bytebuddy.implementation.attribute.TypeAttributeAppender.ForInstrumentedType.Differentiating;

@RestController
@CrossOrigin("*")
@RequestMapping("/quizz")
public class QuizzController {
	
	
   @Autowired
   IQuizzService quizzService ; 
   
   
    @Autowired
    IQuestionService questionService;
	
	@PostMapping("/createquizz")
	Quizz createQuizz(@RequestParam ("duration") int duration , @RequestParam("diff") Difuculte diff , @RequestParam("catId") Long idCat) {
		return quizzService.createQuizz(duration , diff , idCat);
	}
}
