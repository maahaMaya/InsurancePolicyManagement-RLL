package com.gfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gfive.domain.Policy;
import com.gfive.proxy.PolicyServiceProxy;

@RestController
@Scope("request")
public class PolicyClientController {
	@Autowired
	private PolicyServiceProxy policyServiceProxy;
	
	@GetMapping("/viewAllPolicy")
	public List<Policy> getAllPolicy() {
		List<Policy> policy = policyServiceProxy.vieAllPolicy();
		return policy;
	}
	
	@GetMapping("/searchPolicyById/{id}")
	public Policy getPolicyById(@PathVariable("id") Integer id) {
		//log.debug("In getPolicyById with Id: " + id);
		Policy policy = policyServiceProxy.searchPolicyById(id);
		//log.debug("In getPolicyById with return value Policy " + product);
		return policy;
	}
	
	@PostMapping(value = "/addPolicy", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Policy addPolicy(@RequestBody Policy policy) {
		return policyServiceProxy.addPolicy(policy);
	}
	
	@PutMapping(value = "/updatePolicy", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public Policy updatePolicy(@RequestBody Policy policy) {
		return policyServiceProxy.updatePolicy(policy);
	}
	
	@DeleteMapping("/deletePolicyById/{policy_id}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deletePolicyById(@PathVariable int policy_id) {
		return policyServiceProxy.deletePolicyById(policy_id);
	}
	
	@GetMapping(value = "/searchPolicy/{serachKeyword}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Policy> serchPolicyByKeyword(@PathVariable String serachKeyword){
		return policyServiceProxy.serchPolicyByKeyword(serachKeyword);
	}
	
	@GetMapping(value = "/viewAllPolicyByPriceSorting")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Policy> viewAllPolicyByPriceSorting(){
		return policyServiceProxy.viewAllPolicyByPriceSorting();
	}
}
