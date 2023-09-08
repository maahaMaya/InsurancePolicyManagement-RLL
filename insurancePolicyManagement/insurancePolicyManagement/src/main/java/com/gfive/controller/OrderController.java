package com.gfive.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gfive.domain.GetOrderDetails;
import com.gfive.domain.Order;
import com.gfive.domain.Policy;
import com.gfive.service.IOrderService;

@RestController
@Scope(value = "request")
public class OrderController {
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	// add order
	@PostMapping(value = "/addOrder", produces = {MediaType.APPLICATION_JSON_VALUE},  consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Order addPolicy(@RequestBody GetOrderDetails getOrderDetails) {
		try {
			Order orderAddResult = orderService.createOrdered(getOrderDetails);
			if (orderAddResult != null) {
				return orderAddResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// get all order
	@GetMapping(value = "/viewAllOrder", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> getAllOrder(HttpSession httpSession) {
		try {
			return orderService.getAllOrder(httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// approve order status
	@GetMapping(value = "/approveOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public  Order approveOrderStatus(@PathVariable Integer applicationId, HttpSession httpSession) {
		try {
			return orderService.approveOrderStatus(applicationId, httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// approve order status
	@GetMapping(value = "/declineOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public  Order declineOrderStatus(@PathVariable Integer applicationId, HttpSession httpSession) {
		try {
			return orderService.declineOrderStatus(applicationId, httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// approve order status
	@GetMapping(value = "/waitingOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public  Order waitingOrderStatus(@PathVariable Integer applicationId, HttpSession httpSession) {
		try {
			return orderService.waitingOrderStatus(applicationId, httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// get all user order
	@GetMapping(value = "/viewUserOrder/{userEmailId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> getUserOrder(@PathVariable String userEmailId, HttpSession httpSession) {
		try {
			return orderService.getUserOrder(userEmailId, httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// get admin search order
	@GetMapping(value = "/serachOrderByKeyword/{searchKeyword}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> serachOrderByKeyword(@PathVariable String searchKeyword, HttpSession httpSession) {
		try {
			return orderService.serachOrderByKeyword(searchKeyword, httpSession);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
