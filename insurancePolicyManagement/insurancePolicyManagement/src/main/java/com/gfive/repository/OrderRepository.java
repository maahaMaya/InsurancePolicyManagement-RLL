package com.gfive.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfive.domain.Order;

@Repository(value = "orderRepository")
@Scope(value = "singleton")
public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}

