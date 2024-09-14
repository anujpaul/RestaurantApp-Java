package com.paul.mughaldynasty.build_restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.paul.mughaldynasty.build_restaurant.bean.OrderStatus;
import com.paul.mughaldynasty.build_restaurant.bean.OrderTable;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {


	@Query("SELECT MAX(orderNumber)+1 from OrderTable")
	Long nextOrder();


	List<OrderTable> findByStatus(OrderStatus status);
}
