package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.ContactUs;
import com.gfive.domain.UserQuestion;

public interface IQuestionsService {
	//add General Question
	public ContactUs addToContactUs(ContactUs contactUs);
	
	//view all General Question
	public List<ContactUs> viewAllContactUs(HttpSession httpSession);
	
	//add User Question
	public UserQuestion addToUserQuestion(String userMessage, HttpSession httpSession);
	
	//view all User Question
	public List<UserQuestion> viewAllUserQuestion(HttpSession httpSession);
}
