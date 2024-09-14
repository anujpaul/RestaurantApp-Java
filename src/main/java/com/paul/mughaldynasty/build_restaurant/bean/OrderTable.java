package com.paul.mughaldynasty.build_restaurant.bean;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orderstatustable")
public class OrderTable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderstatus_seq")
	@SequenceGenerator(name = "orderstatus_seq", sequenceName = "orderstatustable_seq", allocationSize = 1)
	@Column(name = "ordernumber")
	private Long orderNumber;

	private OrderStatus status;

	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "orderTable")
	@JsonManagedReference
	private List<OrderItemTable> orderItems;

	// Constructors
	public OrderTable() {

		super();
	}

	public OrderTable(Long orderNumber, OrderStatus status, LocalDateTime createdAt) {
		super();
		this.orderNumber = orderNumber;
		this.status = status;
		this.createdAt = createdAt;
	}


	// Getters and setters
	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<OrderItemTable> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemTable> orderItems) {
		this.orderItems = orderItems;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "OrderTable [orderNumber=" + orderNumber + ", status=" + status + ", createdAt=" + createdAt + "]";
	}


}
