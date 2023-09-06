package com.gfive.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfive.domain.Policy;

@Repository(value = "policyRepository")
@Scope(value = "singleton")
public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	
}
