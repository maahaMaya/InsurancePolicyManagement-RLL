package com.gfive.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.bind.annotation.RestController;

import com.gfive.domain.Policy;
import com.gfive.service.IPolicyService;

@RestController
@Scope(value = "request")
public class PolicyController {

	@Autowired
	@Qualifier("policyService")
	private IPolicyService policyService;

	// add policy
	@PostMapping(value = "/addPolicy", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Policy addPolicy(@RequestBody Policy policy, HttpSession httpSession) {
		try {
			Policy policyAddResult = policyService.addNewPolicy(policy, httpSession);
			if (policyAddResult != null) {
				return policyAddResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// update policy
	@PutMapping(value = "/updatePolicy", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public Policy updatePolicy(@RequestBody Policy policy, HttpSession httpSession) {
		try {
			Policy policyUpdateResult = policyService.updatePolicyById(policy, httpSession);
			if (policyUpdateResult != null) {
				return policyUpdateResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// get all policy
	@GetMapping(value = "/viewAllPolicy", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public List<Policy> vieAllPolicy() {
		try {
			return policyService.viewAllPolicy();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// delete Policy
	@DeleteMapping("/deletePolicyById/{policy_id}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean deletePolicyById(@PathVariable int policy_id, HttpSession httpSession) {
		try {
			if (policyService.deletePolicyById(policy_id, httpSession)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	// get all policy by Search Keyword
	@GetMapping(value = "/searchPolicy/{serachKeyword}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Policy> serchPolicyByKeyword(@PathVariable String serachKeyword) {
		try {
			return policyService.searchPolicyByKeyword(serachKeyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// get all policy by Search Id
	@GetMapping(value = "/searchPolicyById/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Policy searchPolicyById(@PathVariable Integer id) {
		try {
			return policyService.searchPolicyById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// get all policy by Sorting Asc by Price
	@GetMapping(value = "/viewAllPolicyByPriceSorting")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Policy> viewAllPolicyByPriceSorting() {
		try {
			return policyService.viewAllPolicyByPriceSorting();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
