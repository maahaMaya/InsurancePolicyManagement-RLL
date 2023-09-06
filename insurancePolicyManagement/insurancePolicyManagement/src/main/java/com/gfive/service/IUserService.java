package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.User;

public interface IUserService {
	//Methods to add a new User
	public User addNewUser(User user);
	
	//Methods to login User
	public boolean userLogin(String emailId, String password, HttpSession httpSession);
	
	//Methods to login User
	public boolean userLogut(HttpSession httpSession);
	
	//Method to update User
	public boolean updateUser(User user);
	
	//Method to delete User
	public boolean deleteUser(String emailId);
	
	//Method to view all User
	public List<User> viewAllUser(HttpSession httpSession);
	
	//Search User using keyword
	public List<User> viewSearchKeywordUser(String searchKeyword);
	
	//update User password
	public boolean updateUserPassword(String emailId, String oldPassword, String newPassword);	
}
