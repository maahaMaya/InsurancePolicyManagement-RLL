package com.gfive.domain;

public class GetOrderDetails {
	
	private String user_emailid;
	
	private Policy policy;

	
	public GetOrderDetails(String user_emailid, Policy policy) {
		this.user_emailid = user_emailid;
		this.policy = policy;
	}

	public String getUser_emailid() {
		return user_emailid;
	}

	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	
	
}
