package com.gfive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "policy_details")
public class Policy {
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policy_id;

	@Column(name = "policy_name")
	private String policy_name;

	@Column(name = "policy_category")
	private String policy_category;

	@Column(name = "policy_price")
	private Float policy_price;

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(Integer policy_id, String policy_name, String policy_category, Float policy_price) {
		super();
		this.policy_id = policy_id;
		this.policy_name = policy_name;
		this.policy_category = policy_category;
		this.policy_price = policy_price;
	}

	public Integer getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(Integer policy_id) {
		this.policy_id = policy_id;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public String getPolicy_category() {
		return policy_category;
	}

	public void setPolicy_category(String policy_category) {
		this.policy_category = policy_category;
	}

	public Float getPolicy_price() {
		return policy_price;
	}

	public void setPolicy_price(Float policy_price) {
		this.policy_price = policy_price;
	}

}
