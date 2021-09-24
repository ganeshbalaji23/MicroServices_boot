package com.love.java.coding.ordermicroservice.service;

import java.util.Set;

import com.love.java.coding.ordermicroservice.entity.OrderEntity;
import com.love.java.coding.ordermicroservice.model.TransactionRequest;
import com.love.java.coding.ordermicroservice.model.TransactionResponse;

public interface OrderService {
	
	public Set<OrderEntity> getAllOrders(Integer userId);
	
	public OrderEntity getOrder(Integer orderId);
	
	public TransactionResponse newOrder(TransactionRequest request);
	
	public Integer cancelOrder(Integer orderId);

}
