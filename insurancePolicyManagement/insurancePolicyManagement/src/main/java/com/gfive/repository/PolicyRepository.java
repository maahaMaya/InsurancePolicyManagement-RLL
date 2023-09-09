package com.gfive.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gfive.domain.Policy;

@Repository(value = "policyRepository")
@Scope(value = "singleton")
public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	
	@Query("SELECT p FROM Policy p WHERE ((p.policy_name LIKE %?1%) OR (p.policy_category LIKE %?1%) OR (p.policy_price LIKE %?1%))")
	public List<Policy> searchPolicyByKeyWord(String serachPolicyKeyword);

	@Query("SELECT p FROM Policy p WHERE ((policy_id LIKE %?1%))")
	public Policy searchPolicyById(Integer serachPolicyByid);
}
