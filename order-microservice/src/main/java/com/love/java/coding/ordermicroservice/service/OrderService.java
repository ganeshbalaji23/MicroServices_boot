package com.love.java.coding.ordermicroservice.service;

import java.util.Set;

import com.love.java.coding.ordermicroservice.entity.OrderEntity;

public interface OrderService {
	
	public Set<OrderEntity> getAllOrders(Integer userId);
	
	public OrderEntity getOrder(Integer orderId);
	
	public Integer newOrder(OrderEntity order);
	
	public Integer cancelOrder(Integer orderId);

}
