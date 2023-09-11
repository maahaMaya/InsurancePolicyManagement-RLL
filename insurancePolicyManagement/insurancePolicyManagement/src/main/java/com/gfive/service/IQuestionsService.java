package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.ContactUs;
import com.gfive.domain.UserQuestion;

public interface IQuestionsService {
	//add General Question
	public ContactUs addToContactUs(ContactUs contactUs);
	
	//view all General Question
	public List<ContactUs> viewAllContactUs();
	
	//add User Question
	public UserQuestion addToUserQuestion(UserQuestion userQuestion);
	
	//view all User Question
	public List<UserQuestion> viewAllUserQuestion();
}
