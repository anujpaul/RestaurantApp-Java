package com.paul.mughaldynasty.build_restaurant.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.paul.mughaldynasty.build_restaurant.bean.OrderStatus;
import com.paul.mughaldynasty.build_restaurant.bean.OrderTable;
import com.paul.mughaldynasty.build_restaurant.repository.OrderRepository;

@Service
public class OrderStatusScheduler {

	@Autowired
	private OrderRepository orderRepository;

	// Run the task every minute
	@Scheduled(fixedRate = 60000) // 60 seconds
	public void updateOrderStatuses() {
		List<OrderTable> orders = orderRepository.findAll();

		LocalDateTime now = LocalDateTime.now();

		for (OrderTable order : orders) {
			LocalDateTime createdAt = order.getCreatedAt();

			if (createdAt == null) {
				// Skip orders with no creation time
				continue;
			}

			if (order.getStatus() == OrderStatus.New) {
				if (createdAt.plusMinutes(1).isBefore(now)) {
					// Change status to In_Progress if 1 minute has passed
					order.setStatus(OrderStatus.In_Progress);
					orderRepository.save(order);
				}
			}

			if (order.getStatus() == OrderStatus.In_Progress) {
				if (createdAt.plusMinutes(2).isBefore(now)) {
					// Change status to Ready if 2 minutes have passed
					order.setStatus(OrderStatus.Ready);
					orderRepository.save(order);
				}
			}

			if (order.getStatus() == OrderStatus.Ready) {
				if (createdAt.plusMinutes(3).isBefore(now)) {
					// Change status to Completed if 3 minutes have passed
					order.setStatus(OrderStatus.Completed);
					orderRepository.save(order);
				}
			}
		}
	}
}
