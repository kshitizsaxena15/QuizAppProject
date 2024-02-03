package com.horizon.quizapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.horizon.quizapp.Entities.QuestionWrapper;
import com.horizon.quizapp.Entities.Questions;
import com.horizon.quizapp.Entities.Quiz;
import com.horizon.quizapp.Entities.Response;
import com.horizon.quizapp.repository.QuestionRepo;
import com.horizon.quizapp.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	QuestionRepo questionRepo;
	
	public ResponseEntity<String> createQuiz(String category, int numOfQ, String title) {
		
		System.out.println("Category, Title and NumOfQ:: "+category+" " + numOfQ+ "  "+title);
		List<Questions> questions= questionRepo.findRandomQuestionsByCategory(category,numOfQ);
		
		System.out.println("Questions:::::"+questions);
		
		Quiz quiz= new Quiz();
		
		quiz.setQuizTitle(title);
		quiz.setQuestions(questions);
		
		quizRepository.save(quiz);
		
		return new ResponseEntity<String>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(String title) {
		Quiz quiz= quizRepository.findByQuizTitle(title);
		List<QuestionWrapper> questionWrappers=new ArrayList<>();
		quiz.getQuestions().forEach(questions-> {
			QuestionWrapper questionWrapper=new QuestionWrapper(questions.getQid(), questions.getQuestionTitle(), questions.getOption1(), questions.getOption2(), questions.getOption3(), questions.getOption4());
			questionWrappers.add(questionWrapper);
		});
		
		return new ResponseEntity<List<QuestionWrapper>>(questionWrappers,HttpStatus.OK);
	}

	public ResponseEntity<String> calculateResult(int id, List<Response> responses) {

		Quiz quiz= quizRepository.findById(id).get();
		List<Questions> questions= quiz.getQuestions();
		
		int marks=0;
		
		for(int i=0;i<responses.size();i++) {
			int qid= responses.get(i).getQid();
			String answer=responses.get(i).getAnswer();
			for(int j=0;j<questions.size();j++) {
				int quesId=questions.get(j).getQid();
				if(qid==quesId) {
					String rightAnswer= questions.get(j).getRightAnswer();
					if(rightAnswer.equals(answer)) {
						marks++;
					}
				}
			}
		}
		String result= "Total marks are: "+marks;
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	

}
