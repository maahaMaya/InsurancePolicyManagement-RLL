package com.gfive.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gfive.domain.ContactUs;
import com.gfive.domain.UserQuestion;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "product-service")
public interface QuestionServiceProxy {

	// add general query
	//@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAddGeneralQuery")
	@PostMapping(value = "/addGeneralQuery", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContactUs addGeneralQuery(@RequestBody ContactUs contactUs);

	// get all general Query
	@Retry(name = "product-service")
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodViewAllContactUs")
	@GetMapping(value = "/viewAllContactUs", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<ContactUs> viewAllContactUs();

	// add user query
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAddUserQuery")
	@PostMapping(value = "/addUserQuery", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserQuestion addUserQuery(@RequestBody UserQuestion userQuestion);

	// get all user Query
	@Retry(name = "product-service")
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodViewAllUserQuestion")
	@GetMapping(value = "/viewAllUserQuestion", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserQuestion> viewAllUserQuestion();
	
	public default UserQuestion fallbackMethodAddGeneralQuery(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodAddGeneralQuery ===> " + cause.getMessage());
		return null;
	}
	
	public default List<UserQuestion> fallbackMethodViewAllContactUs(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodViewAllContactUs ===> " + cause.getMessage());
		return new ArrayList<UserQuestion>();
	}
	
	public default UserQuestion fallbackMethodAddUserQuery(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodAddUserQuery ===> " + cause.getMessage());
		return null;
	}
	
	public default List<UserQuestion> fallbackMethodViewAllUserQuestion(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodViewAllUserQuestion ===> " + cause.getMessage());
		return new ArrayList<UserQuestion>();
	}
}
