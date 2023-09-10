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
import com.gfive.domain.LoginCredentails;
import com.gfive.proxy.AdminServiceProxy;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@Scope("request")
public class AdminClientController {
	
	@Autowired
	private AdminServiceProxy adminServiceProxy;
	
	private Logger log = LoggerFactory.getLogger(AdminClientController.class);
	
	@GetMapping(value = "/getAllAdmin", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Admin> getAllAdmin(){
		try {
			return adminServiceProxy.getAllAdmin();
		} catch (Exception e) {
			
		}
		return null;
	}

	@PostMapping(value = "/adminLogin")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean adminLogin(@RequestBody LoginCredentails loginCredentails) {
		System.out.println("In loginCredentails : " + loginCredentails.toString());
		boolean result = adminServiceProxy.adminLogin(loginCredentails);
		System.out.println("Admin Login Result " + result);
		return result;
	}

	@PostMapping(value = "/adminLogut")
	public boolean adminLogut() {
		return adminServiceProxy.adminLogut();
	}
}
