package com.horizon.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizon.quizapp.Entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	Quiz findByQuizTitle(String title);


}
