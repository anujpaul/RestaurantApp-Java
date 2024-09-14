package com.paul.mughaldynasty.build_restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.paul.mughaldynasty.build_restaurant.bean.OrderItemTable;

import jakarta.transaction.Transactional;

public interface OrderItemRepositary extends JpaRepository<OrderItemTable, Long> {

//	@Query("SELECT MAX(id)+1 FROM OrderItemTable")
	//Long nextId();

	@Transactional
	void deleteByOrderTable_OrderNumber(Long orderNumber);
}
