package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.User;

public interface IUserService {
	// Methods to add a new User
	public User addNewUser(User user);

	// Methods to login User
	//public boolean userLogin(String emailId, String password, HttpSession httpSession);
	public boolean userLogin(String emailId, String password);

	// Methods to login User
	//public boolean userLogut(HttpSession httpSession);
	public boolean userLogut();

	// Method to update User
	public boolean updateUser(User user);

	// Method to delete User
	public boolean deleteUser(String emailId);

	// Method to view all User
	// List<User> viewAllUser(HttpSession httpSession);
	public List<User> viewAllUser();

	// update User password
	public boolean updateUserPassword(String emailId, String oldPassword, String newPassword);

	// Search User using keyword
	//public List<User> viewUserBySearchKeyword(String searchKeyword, HttpSession httpSession);
	public List<User> viewUserBySearchKeyword(String searchKeyword);

	// Search User using keyword
	//public User viewUserByEmail(String searchByEmail, HttpSession httpSession);
	public User viewUserByEmail(String searchByEmail);
}
