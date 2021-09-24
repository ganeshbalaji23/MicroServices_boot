package com.love.java.coding.ordermicroservice.model;

import com.love.java.coding.ordermicroservice.entity.OrderEntity;

public class TransactionResponse {
	
	private OrderEntity order;
	
	private Integer shippingId;
	
	private Integer shippingCost;
	
	private String message;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Integer getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Integer shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
