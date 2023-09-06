package com.gfive.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gfive.domain.User;
import com.gfive.service.IUserService;


@RestController
@Scope(value = "request")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@PostMapping(value = "/addUser", produces = {MediaType.APPLICATION_JSON_VALUE},  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		try {
			userService.addNewUser(user);
			return user;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping(value = "/viewAllUser", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> vieAllUser(HttpSession httpSession) {
		try {
			return userService.viewAllUser(httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PostMapping(value = "/loginUser", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogin(@RequestBody Map userLoginCredentials, HttpSession httpSession) {
		try {
			String emaiId = (String) userLoginCredentials.get("emailId");
			String password = (String) userLoginCredentials.get("password");
			return userService.userLogin(emaiId, password, httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@GetMapping(value = "/logutUser")
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogut(HttpSession httpSession) {
		try {
			return userService.userLogut(httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@PutMapping(value = "/updateUser")
	public boolean updateUser(@RequestBody User user) {
		try {
			if(userService.updateUser(user)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@DeleteMapping(value = "/deleteUser/{userEmailId}")
	public boolean deleteUser(@PathVariable String userEmailId) {
		try {
			if(userService.deleteUser(userEmailId)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
//	@GetMapping(value = "/viewAllByUser/{searchKeyword}")
//	public List<User> vieAllUserBySearchKeyword(@PathVariable String searchKeyword) {
//		try {
//			return userService.viewSearchKeywordUser(searchKeyword);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return null;
//	}
//	
//	@GetMapping(value = "/viewBy/{emailId}")
//	public Optional<User> viewUserByEmailId(@PathVariable String emailId) {
//		try {
//			//return userService.searchUserByEmail(emailId);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return null;
//	}
	
	@PutMapping(value = "/updatePassword")
	public boolean updateUserPassword(@RequestBody Map adminUpdatePassword) {
		try {
			String emaiId = (String) adminUpdatePassword.get("emailId");
			String oldPassword = (String) adminUpdatePassword.get("oldPassword");
			String newPassword = (String) adminUpdatePassword.get("newPassword");
			return userService.updateUserPassword(emaiId, oldPassword, newPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
