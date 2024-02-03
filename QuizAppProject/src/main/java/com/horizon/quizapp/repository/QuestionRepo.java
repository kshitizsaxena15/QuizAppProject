package com.horizon.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.horizon.quizapp.Entities.Questions;

@Repository
public interface QuestionRepo extends JpaRepository<Questions,Integer>  {

	List<Questions> findByCategory(String category);

	@Query(value= "Select * from questions q where q.category=:category ORDER BY RAND() Limit :numOfQ", nativeQuery = true)
	List<Questions> findRandomQuestionsByCategory(String category, int numOfQ);

}
