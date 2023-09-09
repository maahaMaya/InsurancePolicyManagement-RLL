package com.gfive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gfive.domain.Policy;
import com.gfive.proxy.PolicyServiceProxy;

@RestController
@Scope("request")
public class PolicyClientController {
	@Autowired
	private PolicyServiceProxy policyServiceProxy;
	
	@GetMapping("/getPolicy")
	public List<Policy> getAllPolicy() {
		List<Policy> policy = policyServiceProxy.getAllPolicy();
		return policy;
	}
	
	@GetMapping("/getPolicy/{id}")
	public Policy getPolicyById(@PathVariable("id") Integer id) {
		//log.debug("In getPolicyById with Id: " + id);
		Policy policy = policyServiceProxy.getPolicyById(id);
		//log.debug("In getPolicyById with return value Policy " + product);
		return policy;
	}
}
