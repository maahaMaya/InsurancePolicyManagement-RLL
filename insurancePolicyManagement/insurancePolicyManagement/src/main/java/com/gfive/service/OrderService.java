package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gfive.domain.GetOrderDetails;
import com.gfive.domain.Order;
import com.gfive.domain.Policy;
import com.gfive.repository.OrderRepository;

@Service(value = "orderService")
@Scope(value = "singleton")
public class OrderService implements IOrderService {
	@Autowired
	@Qualifier(value = "orderRepository")
	private OrderRepository orderRepository;

	@Override
	public Order createOrdered(GetOrderDetails getOrderDetails) {
		try {
			int applicationId = (int) ((Math.random() * (9999 - 2222)) + 2222);
			java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
			Order order = new Order(applicationId, getOrderDetails.getUser_emailid(), currentDate, "WAITING",
					getOrderDetails.getPolicy());
			return orderRepository.save(order);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Order> getAllOrder(HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			return orderRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Order approveOrderStatus(Integer applicationId, HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			List<Order> allOrderList = orderRepository.findAll();
			for (Order orderData : allOrderList) {
				if ((orderData.getApplication_id()).equals(applicationId)) {
					orderData.setOrder_status("APPROVE");
					return orderRepository.saveAndFlush(orderData);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Order waitingOrderStatus(Integer applicationId, HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			List<Order> allOrderList = orderRepository.findAll();
			for (Order orderData : allOrderList) {
				if ((orderData.getApplication_id()).equals(applicationId)) {
					orderData.setOrder_status("WAITING");
					return orderRepository.saveAndFlush(orderData);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Order declineOrderStatus(Integer applicationId, HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			List<Order> allOrderList = orderRepository.findAll();
			for (Order orderData : allOrderList) {
				if ((orderData.getApplication_id()).equals(applicationId)) {
					orderData.setOrder_status("DECLINE");
					return orderRepository.saveAndFlush(orderData);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Order> getUserOrder(String customerEmailId, HttpSession httpSession) {
		try {
			String emailId = (String) httpSession.getAttribute("userLoginEmail");
			if (!(emailId).equals("")) {
				return orderRepository.searchOrderByKeyWord(customerEmailId);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Order> serachOrderByKeyword(String serchKeyword, HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			return orderRepository.searchOrderByKeyWord(serchKeyword);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
