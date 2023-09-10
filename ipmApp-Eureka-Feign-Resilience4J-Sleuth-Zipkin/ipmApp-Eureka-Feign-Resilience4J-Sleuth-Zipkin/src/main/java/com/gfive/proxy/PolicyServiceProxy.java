package com.gfive.proxy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gfive.domain.Policy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "product-service")
public interface PolicyServiceProxy {
	@Retry(name = "product-service")
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetAllPolicy")
	@GetMapping(value = "/viewAllPolicy", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Policy> vieAllPolicy();
	
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetPolicyById")
	@GetMapping(value = "/searchPolicyById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Policy searchPolicyById(@PathVariable("id") Integer id);
	
	//@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAddPolicy")
	@PostMapping(value = "/addPolicy", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Policy addPolicy(@RequestBody Policy policy);
	
	public default List<Policy> fallbackMethodGetAllPolicy(Throwable cause) {
		System.out.println("Exception raise with message:===> "+ cause.getMessage());
		return new ArrayList<Policy>();
	}
	
	public default Policy fallbackMethodGetPolicyById(Integer id, Throwable cause) {
		System.out.println("Exception raise with message:===> "+ cause.getMessage());
		return new Policy(id, "Happy Home", "Home", (float) 2669.00);
	}
	
	public default Policy fallbackMethodAddPolicy(Throwable cause) {
		System.out.println("Exception raise with message:===> "+ cause.getMessage());
		return null;
	}

}
