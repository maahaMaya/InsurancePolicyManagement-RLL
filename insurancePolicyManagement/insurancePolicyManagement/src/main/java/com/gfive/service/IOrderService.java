package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.GetOrderDetails;
import com.gfive.domain.Order;

public interface IOrderService {
	//add order
	public Order createOrdered(GetOrderDetails getOrderDetails);
	
	//get all order
	public List<Order> getAllOrder();
	
	//approve order status change
	public Order approveOrderStatus(Integer applicationId);
	
	//approve order status change
	public Order waitingOrderStatus(Integer applicationId);
	
	//approve order status change
	public Order declineOrderStatus(Integer applicationId);
	
	//get order customer order
	public List<Order> getUserOrder(String customerEmailId);
	
	//get order customer order
	public List<Order> serachOrderByKeyword(String customerEmailId);
}
