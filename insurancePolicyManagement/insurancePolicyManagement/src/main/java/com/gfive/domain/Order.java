package com.gfive.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;

	@Column(name = "application_id")
	private Integer application_id;

	@Column(name = "user_emailid")
	private String user_emailid;

	@Column(name = "currdate")
	private Date currDate;

	@Column(name = "order_status")
	private String order_status;

	@OneToOne
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
