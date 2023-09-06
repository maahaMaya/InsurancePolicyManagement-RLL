package com.gfive.controller;

import java.util.List;
import java.util.Map;

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
import com.gfive.service.IAdminService;

@RestController
@Scope(value = "request")
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;

	@GetMapping(value = "/getAllAdmin", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@PostMapping(value = "/adminLogin", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean adminLogin(@RequestBody Map adminLoginCredentialst, HttpSession httpSession) {
		try {
			String emaiId = (String) adminLoginCredentialst.get("emailId");
			String password = (String) adminLoginCredentialst.get("password");
			return adminService.adminLogin(emaiId, password, httpSession);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@PostMapping(value = "/adminLogut", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public boolean adminLogut(HttpSession httpSession) {
		try {
			return adminService.adminLogut(httpSession);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
