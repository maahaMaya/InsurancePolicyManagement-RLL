package com.gfive.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfive.domain.UserQuestion;

@Repository(value = "userQuestionRepository")
@Scope(value = "singleton")
public interface UserQuestionRepository extends JpaRepository<UserQuestion, Integer>{

}