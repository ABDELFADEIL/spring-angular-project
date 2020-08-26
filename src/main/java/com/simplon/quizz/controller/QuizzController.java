package com.simplon.quizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.quizz.entities.Difuculte;
import com.simplon.quizz.entities.Quizz;
import com.simplon.quizz.service.IDifuculteService;
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
    
    @Autowired 
    IDifuculteService diffService;
	
    // creer un quizz avec 10 question en random 
	@PostMapping("/createquizz")
	Quizz createQuizz(@RequestParam ("duration") int duration , @RequestParam("diffId") Long diffId , @RequestParam("catId") Long idCat) {
		return quizzService.createQuizz(duration , diffId , idCat);
	}
	
	// recupere liste de niveau 
	@GetMapping("/listlevel")
	List<Difuculte> getAllLevel(){
		return diffService.listDifuculte();
	}
}
