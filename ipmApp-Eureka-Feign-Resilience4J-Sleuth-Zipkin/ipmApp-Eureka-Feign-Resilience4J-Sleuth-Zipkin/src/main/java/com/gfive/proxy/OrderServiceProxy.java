package com.gfive.proxy;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.gfive.domain.GetOrderDetails;
import com.gfive.domain.Order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "product-service")
public interface OrderServiceProxy {
	// add order
	@Retry(name = "product-service")
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodAddOrder")
	@PostMapping(value = "/addOrder", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Order addOrder(@RequestBody GetOrderDetails getOrderDetails);

	// get all order
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodViewAllOrder")
	@GetMapping(value = "/viewAllOrder", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> viewAllOrder();

	// approve order status
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodApproveOrder")
	@GetMapping(value = "/approveOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Order approveOrder(@PathVariable Integer applicationId);

	// approve order status
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodDeclineOrder")
	@GetMapping(value = "/declineOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Order declineOrder(@PathVariable Integer applicationId);

	// approve order status
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodWaitingOrder")
	@GetMapping(value = "/waitingOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Order waitingOrder(@PathVariable Integer applicationId);

	// get all user order
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodViewUserOrder")
	@GetMapping(value = "/viewUserOrder/{userEmailId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> viewUserOrder(@PathVariable String userEmailId);

	// get admin search order
	@CircuitBreaker(name = "product-service", fallbackMethod = "fallbackMethodSerachOrderByKeyword")
	@GetMapping(value = "/serachOrderByKeyword/{searchKeyword}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> serachOrderByKeyword(@PathVariable String searchKeyword);
	
	
	public default List<Order> fallbackMethodViewAllOrder(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodViewAllOrder ===> " + cause.getMessage());
		return new ArrayList<Order>();
	}
	
	public default List<Order> fallbackMethodSerachOrderByKeyword(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodSerachOrderByKeyword ===> " + cause.getMessage());
		return new ArrayList<Order>();
	}
	
	public default List<Order> fallbackMethodViewUserOrder(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodViewUserOrder ===> " + cause.getMessage());
		return new ArrayList<Order>();
	}
	
	public default Order fallbackMethodAddOrder(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodAddOrder ===> " + cause.getMessage());
		return null;
	}
	
	public default Order fallbackMethodApproveOrder(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodApproveOrder ===> " + cause.getMessage());
		return null;
	}
	
	public default Order fallbackMethodDeclineOrder(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodDeclineOrder ===> " + cause.getMessage());
		return null;
	}
	
	public default Order fallbackMethodWaitingOrder(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodWaitingOrder ===> " + cause.getMessage());
		return null;
	}

	public default boolean fallbackMethodUpdateUserPassword(Throwable cause) {
		System.out.println("Exception raise with message: fallbackMethodUpdateUserPassword ===> " + cause.getMessage());
		return false;
	}
}
