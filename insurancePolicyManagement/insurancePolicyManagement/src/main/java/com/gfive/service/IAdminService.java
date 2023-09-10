package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.Admin;

public interface IAdminService {
	public List<Admin> getAllAdmin();
	
	//admin Login
	//public boolean adminLogin(String adminEmail, String AdminPassword, HttpSession httpSession);
	public boolean adminLogin(String adminEmail, String AdminPassword);
	
	//admin Login
	public boolean adminLogut();
	
	
}
