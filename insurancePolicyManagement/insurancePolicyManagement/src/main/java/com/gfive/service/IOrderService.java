package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.GetOrderDetails;
import com.gfive.domain.Order;

public interface IOrderService {
	//add order
	public Order createOrdered(GetOrderDetails getOrderDetails);
	
	//get all order
	public List<Order> getAllOrder(HttpSession httpSession);
	
	//approve order status change
	public Order approveOrderStatus(Integer applicationId, HttpSession httpSession);
	
	//approve order status change
	public Order waitingOrderStatus(Integer applicationId, HttpSession httpSession);
	
	//approve order status change
	public Order declineOrderStatus(Integer applicationId, HttpSession httpSession);
	
	//get order customer order
	public List<Order> getUserOrder(String customerEmailId, HttpSession httpSession);
	
	//get order customer order
	public List<Order> serachOrderByKeyword(String customerEmailId, HttpSession httpSession);
}
