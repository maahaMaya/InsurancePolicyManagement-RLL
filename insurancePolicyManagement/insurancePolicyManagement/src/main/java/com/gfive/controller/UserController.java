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

import com.gfive.domain.LoginCredentails;
import com.gfive.domain.UpdatePasswordData;
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
	public List<User> vieAllUser() {
		try {
			return userService.viewAllUser();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PostMapping(value = "/loginUser", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogin(@RequestBody LoginCredentails loginCredentails) {
		try {
			String emaiId = loginCredentails.getEmailId();
			String password = loginCredentails.getPassword();
			return userService.userLogin(emaiId, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@GetMapping(value = "/logutUser")
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogut() {
		try {
			return userService.userLogut();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@PutMapping(value = "/updateUser",  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
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
	@ResponseStatus(code = HttpStatus.OK)
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
	
	@GetMapping(value = "/viewAllByUserSerach/{searchKeyword}")
	public List<User> viewUserBySearchKeyword(@PathVariable String searchKeyword) {
		try {
			return userService.viewUserBySearchKeyword(searchKeyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@GetMapping(value = "/viewUserByEmail/{userEmailId}")
	public User viewUserByEmailId(@PathVariable String userEmailId) {
		try {
			return (User) userService.viewUserByEmail(userEmailId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PutMapping(value = "/updatePassword",  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public boolean updateUserPassword(@RequestBody UpdatePasswordData updatePasswordData) {
		try {
			String emaiId = updatePasswordData.getEmailId();
			String oldPassword = updatePasswordData.getOldPassword();
			String newPassword = updatePasswordData.getNewPassword();
			return userService.updateUserPassword(emaiId, oldPassword, newPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
