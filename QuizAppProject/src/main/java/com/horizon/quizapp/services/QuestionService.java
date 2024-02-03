package com.horizon.quizapp.services;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.horizon.quizapp.Entities.Questions;
import com.horizon.quizapp.repository.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo questionRepo;
	
	public List<Questions> getAllQuestions(){
		
		return questionRepo.findAll();
	}

	public List<Questions> getQuestionsByCategory(String category) {
		return questionRepo.findByCategory(category);
	}

	public ResponseEntity<String> addQuestion(Questions question) {
		questionRepo.save(question);
		return new ResponseEntity<>("Success",HttpStatus.CREATED); 
	}

	public String deleteQuestion(int qid) {
		questionRepo.deleteById(qid);
		return "Success";
	}

}
