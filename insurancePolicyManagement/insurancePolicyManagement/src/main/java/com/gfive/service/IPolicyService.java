package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gfive.domain.Policy;

public interface IPolicyService {
	// Method to add new Policy
	public Policy addNewPolicy(Policy policy, HttpSession httpSession);

	// Method to view all Policy
	public List<Policy> viewAllPolicy();

	// Method to update policy by id
	public Policy updatePolicyById(Policy policy, HttpSession httpSession);

	// Method to delete policy by id
	public boolean deletePolicyById(int policyId, HttpSession httpSession);

	// Method to search Policy By Keyword
	public List<Policy> searchPolicyByKeyword(String serachPolicyKeyword);

	// Method to view all Policy
	public List<Policy> viewAllPolicyByPriceSorting();
}
