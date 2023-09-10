package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.Policy;

public interface IPolicyService {
	// Method to add new Policy
	//public Policy addNewPolicy(Policy policy, HttpSession httpSession);
	public Policy addNewPolicy(Policy policy);

	// Method to view all Policy
	public List<Policy> viewAllPolicy();

	// Method to update policy 
	//public Policy updatePolicyById(Policy policy, HttpSession httpSession);
	public Policy updatePolicy(Policy policy);

	// Method to delete policy by id
	//public boolean deletePolicyById(int policyId, HttpSession httpSession);
	public boolean deletePolicyById(int policyId);

	// Method to Sort Asc all Policy
	public List<Policy> viewAllPolicyByPriceSorting();

	// Method to search Policy By Keyword
	public List<Policy> searchPolicyByKeyword(String serachPolicyKeyword);

	// Method to search Policy By Id
	public Policy searchPolicyById(Integer serachPolicyByid);
}
