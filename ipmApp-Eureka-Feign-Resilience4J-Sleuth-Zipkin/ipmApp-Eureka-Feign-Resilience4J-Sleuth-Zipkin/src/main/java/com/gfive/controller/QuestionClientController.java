package com.gfive.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gfive.domain.Admin;
import com.gfive.domain.ContactUs;
import com.gfive.domain.LoginCredentails;
import com.gfive.domain.UserQuestion;
import com.gfive.proxy.QuestionServiceProxy;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@Scope("request")
public class QuestionClientController {

	// private Logger log = LoggerFactory.getLogger(QuestionClientController.class);

	@Autowired
	private QuestionServiceProxy questionServiceProxy;


	@PostMapping(value = "/addGeneralQuery", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContactUs addGeneralQuery(@RequestBody ContactUs contactUs) {
		return questionServiceProxy.addGeneralQuery(contactUs);
	}
	
	@GetMapping(value = "/viewAllContactUs", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<ContactUs> viewAllContactUs() {
		return questionServiceProxy.viewAllContactUs();
	}


	@PostMapping(value = "/addUserQuery", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserQuestion addUserQuery(@RequestBody UserQuestion userQuestion) {
		return questionServiceProxy.addUserQuery(userQuestion);
	}

	@GetMapping(value = "/viewAllUserQuestion", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserQuestion> viewAllUserQuestion() {
		return questionServiceProxy.viewAllUserQuestion();
	}
}
