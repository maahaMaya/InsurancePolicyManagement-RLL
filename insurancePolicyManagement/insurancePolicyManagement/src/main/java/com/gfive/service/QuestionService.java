package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gfive.domain.ContactUs;
import com.gfive.domain.UserQuestion;
import com.gfive.repository.ContactUsRepository;
import com.gfive.repository.UserQuestionRepository;


@Service(value = "questionService")
@Scope(value = "singleton")
public class QuestionService implements IQuestionsService{
	
	@Autowired
	@Qualifier(value = "userQuestionRepository")
	private UserQuestionRepository userQuestionRepository;
	
	@Autowired
	@Qualifier(value = "contactUsRepository")
	private ContactUsRepository contactUsRepository;

	@Override
	public ContactUs addToContactUs(ContactUs contactUs) {
		try {
			return contactUsRepository.save(contactUs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ContactUs> viewAllContactUs(HttpSession httpSession) {
		if ((httpSession.getAttribute("adminLoginStatus")).equals(true)) {
			return contactUsRepository.findAll();
		}
		return null;
	}

	@Override
	public UserQuestion addToUserQuestion(String userMessage, HttpSession httpSession) {
		String emailId = (String) httpSession.getAttribute("userLoginEmail");
		if (!(emailId).equals("")) {
			UserQuestion userQuestion = new UserQuestion();
			userQuestion.setUserquestion_email(emailId);
			userQuestion.setUserquestion_message(userMessage);
			return userQuestionRepository.save(userQuestion);
		}
		return null;
	}

	@Override
	public List<UserQuestion> viewAllUserQuestion(HttpSession httpSession) {
		if ((httpSession.getAttribute("adminLoginStatus")).equals(true)) {
			return userQuestionRepository.findAll();
		}
		return null;
	}
}
