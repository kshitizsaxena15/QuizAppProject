package com.horizon.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
		System.out.println("Question:"+question);
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable("id") int qid){
		System.out.println("Qid::"+qid);
		return questionService.deleteQuestion(qid);		
	}
}
