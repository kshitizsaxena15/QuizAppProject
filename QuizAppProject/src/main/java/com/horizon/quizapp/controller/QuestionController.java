package com.horizon.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.horizon.quizapp.Entities.Questions;
import com.horizon.quizapp.services.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public List<Questions> getAllQuestions() {
		
		List<Questions> questionList;
		questionList= questionService.getAllQuestions();
		System.out.println("Inside Controller");
		questionList.forEach(question-> {System.out.println("Question is ::"+question);});
		return questionList;
		
	}
	
	@GetMapping("category/{category}")
	public List<Questions> getQuestionsByCategory(@PathVariable("category") String category){
		return questionService.getQuestionsByCategory(category);
	}
}
