package com.gfive.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gfive.domain.Admin;
import com.gfive.domain.LoginCredentails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "product-service")
public interface AdminServiceProxy {

	
	@Retry(name = "product-service")
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodGetAllAdmin")
	@GetMapping(value = "/getAllAdmin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Admin> getAllAdmin();

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAdminLogin")
	@PostMapping(value = "/adminLogin")
	@ResponseStatus(code = HttpStatus.OK)
	public abstract boolean adminLogin(@RequestBody LoginCredentails loginCredentails);

	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAdminLogut")
	@PostMapping(value = "/adminLogut")
	public boolean adminLogut();

	public default List<Admin> fallbackMethodGetAllAdmin(Throwable cause) {
		System.out.println("Exception raise with message:===> " + cause.getMessage());
		return new ArrayList<Admin>();
	}

	public default boolean fallbackMethodAdminLogin(Throwable cause) {
		System.out.println("Exception raise with message : fallbackMethodAdminLogin :===> " + cause.getMessage());
		return false;
	}

	public default boolean fallbackMethodAdminLogut(Throwable cause) {
		System.out.println("Exception raise with message:===> " + cause.getMessage());
		return false;
	}
}
