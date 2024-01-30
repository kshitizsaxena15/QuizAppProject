package com.horizon.quizapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qid;
	
	private String questionTitle;
	
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	

	private String rightAnswer;
	private String difficulty_level;
	
	private String category;
	
	
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Questions(int qid, String questionTitle, String option1, String option2, String option3, String option4,
			String rightAnswer, String difficulty_level, String category) {
		super();
		this.qid = qid;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightAnswer = rightAnswer;
		this.difficulty_level = difficulty_level;
		this.category = category;
	}

	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	



	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", questionTitle=" + questionTitle + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", rightAnswer=" + rightAnswer
				+ ", difficulty_level=" + difficulty_level + ", category=" + category + "]";
	}
	
	
	
}
