package com.gfive.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.gfive.domain.Admin;
import com.gfive.domain.LoginCredentails;
import com.gfive.service.IAdminService;

@RestController
@Scope(value = "request")
public class AdminController {

	private Logger log =LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;

	@GetMapping(value = "/getAllAdmin", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@PostMapping(value = "/adminLogin", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public boolean adminLogin(@RequestBody LoginCredentails loginCredentails) {
		try {
			String emaiId = loginCredentails.getEmailId();
			String password = loginCredentails.getPassword();
			return adminService.adminLogin(emaiId, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@PostMapping(value = "/adminLogut")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public boolean adminLogut() {
		try {
			return adminService.adminLogut();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
