package com.gfive.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gfive.domain.LoginCredentails;
import com.gfive.domain.Policy;
import com.gfive.domain.UpdatePasswordData;
import com.gfive.domain.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "product-service")
public interface UserServiceProxy {

	@Retry(name = "product-service")
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodVieAllUser")
	@GetMapping(value = "/viewAllUser", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> vieAllUser();

	//@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAddUser")
	@PostMapping(value = "/addUser", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user);

	//Not Working
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodLoginUser")
	@PostMapping(value = "/loginUser")
	@ResponseStatus(code = HttpStatus.OK)
	public abstract boolean loginUser(@RequestBody LoginCredentails loginCredentails);

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodUserLogut")
	@GetMapping(value = "/logutUser")
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean userLogut();

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodUpdateUser")
	@PutMapping(value = "/updateUser", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public boolean updateUser(@RequestBody User user);

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodDeleteUser")
	@DeleteMapping(value = "/deleteUser/{userEmailId}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deleteUser(@PathVariable String userEmailId);

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodViewUserBySearchKeyword")
	@GetMapping(value = "/viewAllByUserSerach/{searchKeyword}")
	public List<User> viewUserBySearchKeyword(@PathVariable String searchKeyword);

	//Not Working
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodViewUserByEmailId")
	@GetMapping(value = "/viewUserByEmail/{userEmailId}")
	public User viewUserByEmailId(@PathVariable String userEmailId);

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodUpdateUserPassword")
	@PutMapping(value = "/updatePassword", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public boolean updateUserPassword(@RequestBody UpdatePasswordData updatePasswordData);

	public default List<Policy> fallbackMethodVieAllUser(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodVieAllUser ===> " + cause.getMessage());
		return new ArrayList<Policy>();
	}

	public default Policy fallbackMethodAddUser(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodAddUser ===> " + cause.getMessage());
		return null;
	}

	public default boolean fallbackMethodLoginUser(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodLoginUser ===> " + cause.getMessage());
		return false;
	}
	
	public default boolean fallbackMethodUserLogut(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodUserLogut ===> " + cause.getMessage());
		return false;
	}

	public default boolean fallbackMethodUpdateUser(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodUserLogin ===> " + cause.getMessage());
		return false;
	}

	public default boolean fallbackMethodDeleteUser(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodDeleteUser ===> " + cause.getMessage());
		return false;
	}

	public default List<Policy> fallbackMethodViewUserBySearchKeyword(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodViewUserBySearchKeyword ===> " + cause.getMessage());
		return new ArrayList<Policy>();
	}
	
	public default Policy fallbackMethodViewUserByEmailId(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodViewUserByEmailId ===> " + cause.getMessage());
		return null;
	}

	public default boolean fallbackMethodUpdateUserPassword(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodUpdateUserPassword ===> " + cause.getMessage());
		return false;
	}

}
