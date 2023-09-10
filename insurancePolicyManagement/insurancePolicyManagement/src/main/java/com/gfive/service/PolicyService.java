package com.gfive.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
public class PolicyService implements IPolicyService {

	@Autowired
	@Qualifier(value = "policyRepository")
	private PolicyRepository policyRepository;

	@Override
	public Policy addNewPolicy(Policy policy, HttpSession httpSession) {
		try {
			//System.out.println((httpSession.getAttribute("adminLoginStatus")));
//			if ((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
//				return null;
//			}
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
			if ((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
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
			if ((httpSession.getAttribute("adminLoginStatus")).equals(false)) {
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
		try {
			return policyRepository.searchPolicyByKeyWord(serachPolicyKeyword);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public Policy searchPolicyById(Integer serachPolicyByid) {
		try {
			return (Policy) policyRepository.searchPolicyById(serachPolicyByid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Policy> viewAllPolicyByPriceSorting() {
		try {
			List<Policy>  listAllPolicy =  policyRepository.findAll();
			Collections.sort(listAllPolicy, new SortPolicyByPrice());
			return listAllPolicy;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

//class for the sorting
class SortPolicyByPrice implements Comparator<Policy> {
	public int compare(Policy a, Policy b) {
		return (int) (a.getPolicy_price() - b.getPolicy_price());
	}
}
