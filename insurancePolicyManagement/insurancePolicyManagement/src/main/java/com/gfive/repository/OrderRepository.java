package com.gfive.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gfive.domain.Order;

@Repository(value = "orderRepository")
@Scope(value = "singleton")
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("SELECT o FROM Order o WHERE ((o.application_id LIKE %?1%) OR (o.user_emailid LIKE %?1%) OR (o.order_status LIKE %?1%))")
	public List<Order> searchOrderByKeyWord(String serachOrderKeyword);
}

