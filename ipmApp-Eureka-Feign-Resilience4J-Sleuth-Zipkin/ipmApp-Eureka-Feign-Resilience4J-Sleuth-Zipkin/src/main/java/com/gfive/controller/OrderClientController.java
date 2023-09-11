package com.gfive.controller;

import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gfive.proxy.OrderServiceProxy;

@RestController
@Scope("request")
public class OrderClientController {

	@Autowired
	private OrderServiceProxy orderServiceProxy;

	private Logger log = LoggerFactory.getLogger(OrderClientController.class);

	@PostMapping(value = "/addOrder", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Order addOrder(@RequestBody GetOrderDetails getOrderDetails) {
		Order order = orderServiceProxy.addOrder(getOrderDetails);
		return order;
	}

	@GetMapping(value = "/viewAllOrder", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> viewAllOrder() {
		return orderServiceProxy.viewAllOrder();
	}

	@GetMapping(value = "/approveOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Order approveOrder(@PathVariable Integer applicationId) {
		return orderServiceProxy.approveOrder(applicationId);
	}


	@GetMapping(value = "/declineOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Order declineOrder(@PathVariable Integer applicationId) {
		return orderServiceProxy.declineOrder(applicationId);
	}

	@GetMapping(value = "/waitingOrder/{applicationId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Order waitingOrder(@PathVariable Integer applicationId) {
		return orderServiceProxy.waitingOrder(applicationId);
	}

	@GetMapping(value = "/viewUserOrder/{userEmailId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> viewUserOrder(@PathVariable String userEmailId) {
		return orderServiceProxy.viewUserOrder(userEmailId);
	}


	@GetMapping(value = "/serachOrderByKeyword/{searchKeyword}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Order> serachOrderByKeyword(@PathVariable String searchKeyword) {
		return orderServiceProxy.serachOrderByKeyword(searchKeyword);
	}
}
