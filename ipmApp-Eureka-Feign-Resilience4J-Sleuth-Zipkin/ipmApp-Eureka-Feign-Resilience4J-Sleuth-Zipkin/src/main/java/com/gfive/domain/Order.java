package com.gfive.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private Integer order_id;

	private Integer application_id;

	private String user_emailid;

	private Date currDate;

	private String order_status;

	private Policy policy;

	public Order() {

	}

	
	public Order(Integer application_id, String user_emailid, Date currDate, String order_status, Policy policy) {
		this.application_id = application_id;
		this.user_emailid = user_emailid;
		this.currDate = currDate;
		this.order_status = order_status;
		this.policy = policy;
	}


	public Order(Integer order_id, Integer application_id, String user_emailid, Date currDate, String order_status,
			Policy policy) {
		this.order_id = order_id;
		this.application_id = application_id;
		this.user_emailid = user_emailid;
		this.currDate = currDate;
		this.order_status = order_status;
		this.policy = policy;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getApplication_id() {
		return application_id;
	}

	public void setApplication_id(Integer application_id) {
		this.application_id = application_id;
	}

	public String getUser_emailid() {
		return user_emailid;
	}

	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}

	public Date getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
}
