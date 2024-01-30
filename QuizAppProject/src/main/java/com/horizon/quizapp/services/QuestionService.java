package com.horizon.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
