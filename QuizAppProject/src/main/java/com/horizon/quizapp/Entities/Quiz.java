package com.horizon.quizapp.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;
	
	private String quizTitle;
	
	@ManyToMany
	private List<Questions> questions;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Quiz(int quizId, String quizTitle, List<Questions> questions) {
		super();
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.questions = questions;
	}
	
	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}



	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	

	
}
