package com.gfive.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gfive.proxy.UserServiceProxy;

@RestController
@Scope("request")
public class UserClientController {
	
	private Logger log = LoggerFactory.getLogger(UserClientController.class);
	
	@Autowired
	private UserServiceProxy userServiceProxyProxy;
	
	@PostMapping(value = "/addUser", produces = {MediaType.APPLICATION_JSON_VALUE},  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userServiceProxyProxy.addUser(user);
	}
	
	@GetMapping(value = "/viewAllUser", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> vieAllUser() {
		return userServiceProxyProxy.vieAllUser();
	}
	
	@PostMapping(value = "/loginUser")
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogin(@RequestBody LoginCredentails loginCredentails) {
		System.out.println("In loginCredentails : " + loginCredentails.toString());
		boolean result = userServiceProxyProxy.loginUser(loginCredentails);
		System.out.println("User Login Result " + result);
		return result;
	}
	
	@GetMapping(value = "/logutUser")
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogut() {
		return userServiceProxyProxy.userLogut();
	}
	
	@PutMapping(value = "/updateUser",  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public boolean updateUser(@RequestBody User user) {
		return userServiceProxyProxy.updateUser(user);
	}
	
	@DeleteMapping(value = "/deleteUser/{userEmailId}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deleteUser(@PathVariable String userEmailId) {
		return userServiceProxyProxy.deleteUser(userEmailId);
	}
	
	@GetMapping(value = "/viewAllByUserSerach/{searchKeyword}")
	public List<User> viewUserBySearchKeyword(@PathVariable String searchKeyword) {
		return userServiceProxyProxy.viewUserBySearchKeyword(searchKeyword);
	}

	@GetMapping(value = "/viewUserByEmail/{userEmailId}")
	public User viewUserByEmailId(@PathVariable String userEmailId) {
		return userServiceProxyProxy.viewUserByEmailId(userEmailId);
	}
	
	@PutMapping(value = "/updatePassword",  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public boolean updateUserPassword(@RequestBody UpdatePasswordData updatePasswordData) {
		return userServiceProxyProxy.updateUserPassword(updatePasswordData);
	}
}
