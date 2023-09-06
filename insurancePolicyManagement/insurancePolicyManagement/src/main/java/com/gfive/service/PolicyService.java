package com.gfive.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.gfive.domain.Policy;
import com.gfive.repository.PolicyRepository;


@Service(value = "policyService")
@Scope(value = "singleton")
public class PolicyService implements IPolicyService{

	@Autowired
	@Qualifier(value = "policyRepository")
	private PolicyRepository policyRepository;
	
	@Override
	public Policy addNewPolicy(Policy policy, HttpSession httpSession) {
		try {
			System.out.println((httpSession.getAttribute("adminLoginStatus")));
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			return policyRepository.save(policy);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Policy> viewAllPolicy() {
		try {
			return policyRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public Policy updatePolicyById(Policy policy, HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return null;
			}
			return policyRepository.saveAndFlush(policy);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	@Override
	public boolean deletePolicyById(int policyId, HttpSession httpSession) {
		try {
			if((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
				return false;
			}
			policyRepository.deleteById(policyId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Policy> searchPolicyByKeyword(String serachPolicyKeyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
