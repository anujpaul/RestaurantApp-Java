package com.paul.mughaldynasty.build_restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paul.mughaldynasty.build_restaurant.bean.OrderItemTable;
import com.paul.mughaldynasty.build_restaurant.bean.OrderStatus;
import com.paul.mughaldynasty.build_restaurant.bean.OrderTable;
import com.paul.mughaldynasty.build_restaurant.repository.ItemRepository;
import com.paul.mughaldynasty.build_restaurant.repository.OrderItemRepositary;
import com.paul.mughaldynasty.build_restaurant.repository.OrderRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderStatusController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepositary orderItemRepository;

	@Autowired
	private ItemRepository itemRepository;

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusController.class);


	@GetMapping("/orderstatus")
	public List<OrderTable> getOrderStatus(){
		return orderRepository.findAll();
	}

	@GetMapping("/orderstatus/{id}")
	public Optional<OrderTable> getOrderStatus(@PathVariable Long id) {
		return orderRepository.findById(id);
	}

	@GetMapping("/orderstatus/status/{status}")
	public List<OrderTable> getOrdersByStatus(@PathVariable OrderStatus status) {
		return orderRepository.findByStatus(status);
	}

	@PostMapping("/createorder")
	public String createOrder(@RequestBody OrderTable orderTable) {

		Long itemId = (long) 0;
		Double orderTotal = 0.0;
		logger.info("Let's see if this prints" + orderTable.getOrderNumber());
		Long orderNumber = orderRepository.nextOrder();
		if (orderNumber == null) {
			orderNumber = (long) 1;
		}
		// Generate an order number if not provided
		if (orderTable.getOrderNumber() == null) {
			orderTable.setOrderNumber(orderNumber);
		}
		logger.info("==================================== " + orderTable.toString());

		// Save the order and associated order items
		orderRepository.save(orderTable);
		logger.info("Order Table Saved*******************************");
		if (orderTable.getOrderItems() != null) {
			for (OrderItemTable item : orderTable.getOrderItems()) {
				itemId = item.getItemTable().getId();
				orderTotal += itemRepository.findAmountById(itemId);
				Long orderItemId = orderItemRepository.nextId();
				if (orderItemId == null) {
					orderItemId = (long) 1;
				}
				item.setId(orderItemId);
				item.setOrderTable(orderTable); // Set reference to the order
				logger.info("Amount" + item.getItemTable());
				orderItemRepository.save(item);
				logger.info("OrderItemRepo saved==================================== " + orderTable.getOrderNumber());
			}
		}

		return "Order number " + orderTable.getOrderNumber() + " Created with Total Amount : " + orderTotal;
	}

	@DeleteMapping("/delete/{ordernumber}")
	public String deleteOrderById(@PathVariable Long ordernumber) {
		// OrderTable orderTable = new OrderTable();

		// orderTable.setOrderNumber(ordernumber);
		orderItemRepository.deleteByOrderTable_OrderNumber(ordernumber);
		orderRepository.deleteById(ordernumber);
		return "Order Deleted";

	}
	
	
	

}
