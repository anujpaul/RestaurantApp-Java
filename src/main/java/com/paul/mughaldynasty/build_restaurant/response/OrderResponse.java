package com.paul.mughaldynasty.build_restaurant.response;

public class OrderResponse {

	private String message;
	private Long orderNumber;
	private Double orderTotal;
	
	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}

	public OrderResponse(String message, Long orderNumber, Double orderTotal) {
		super();
		this.message = message;
		this.orderNumber = orderNumber;
		this.orderTotal = orderTotal;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	
	
}
