package com.gfive.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gfive.domain.ContactUs;
import com.gfive.domain.UserQuestion;
import com.gfive.service.IQuestionsService;


@RestController
@Scope(value = "request")
public class QuestionController {
	
	@Autowired
	@Qualifier("questionService")
	private IQuestionsService questionService;
	
	// add general query
	@PostMapping(value = "/addGeneralQuery", produces = {MediaType.APPLICATION_JSON_VALUE},  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContactUs addUserQuestionAddResult(@RequestBody ContactUs contactUs) {
		try {
			ContactUs contactUsAddResult = questionService.addToContactUs(contactUs);
			if (contactUsAddResult != null) {
				return contactUsAddResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// get all general Query
	@GetMapping(value = "/viewAllContactUs", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<ContactUs> viewAllContactUs() {
		return questionService.viewAllContactUs();
	}
	
	// add user query
	@PostMapping(value = "/addUserQuery", produces = {MediaType.APPLICATION_JSON_VALUE},  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserQuestion addUserQuestionAddResult(@RequestBody UserQuestion userQuestion) {
		try {
			UserQuestion userQuestionAddResult = questionService.addToUserQuestion(userQuestion);
			if (userQuestionAddResult != null) {
				return userQuestionAddResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// get all user Query
	@GetMapping(value = "/viewAllUserQuestion", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserQuestion> viewAllUserQuestion() {
		return questionService.viewAllUserQuestion();
	}
}
