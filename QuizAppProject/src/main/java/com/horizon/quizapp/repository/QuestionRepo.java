package com.horizon.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.horizon.quizapp.Entities.Questions;

@Repository
public interface QuestionRepo extends JpaRepository<Questions,Integer>  {

	List<Questions> findByCategory(String category);

}
