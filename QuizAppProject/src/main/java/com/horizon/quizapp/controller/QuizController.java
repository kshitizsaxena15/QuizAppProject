package com.horizon.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horizon.quizapp.Entities.QuestionWrapper;
import com.horizon.quizapp.Entities.Questions;
import com.horizon.quizapp.Entities.Quiz;
import com.horizon.quizapp.Entities.Response;
import com.horizon.quizapp.services.QuizService; 

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("createQuiz")
	public ResponseEntity<String> createQuiz(@RequestParam String category
			, @RequestParam int numOfQ, @RequestParam String title){
		return quizService.createQuiz(category, numOfQ, title);
	}
	
	@GetMapping("get/{title}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable String title){
		
		return quizService.getQuiz(title);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<String> calculateResult(@PathVariable int id ,@RequestBody List<Response> responses){
			
		return quizService.calculateResult(id, responses);
	}
	
}
