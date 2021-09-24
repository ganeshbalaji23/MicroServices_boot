package com.love.java.coding.ordermicroservice.model;

import com.love.java.coding.ordermicroservice.entity.OrderEntity;

public class TransactionRequest {
	
	private OrderEntity order;
	
	private ShippingEntity shipping;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ShippingEntity getShipping() {
		return shipping;
	}

	public void setShipping(ShippingEntity shipping) {
		this.shipping = shipping;
	}
	
}
