package com.love.java.coding.ordermicroservice.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.java.coding.ordermicroservice.entity.OrderEntity;
import com.love.java.coding.ordermicroservice.repository.OrderRepository;
import com.love.java.coding.ordermicroservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Set<OrderEntity> getAllOrders(Integer userId) {
		return orderRepository.findAllByCustomerId(userId);
	}

	@Override
	public OrderEntity getOrder(Integer orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public Integer newOrder(OrderEntity order) {
		OrderEntity newOrder = orderRepository.save(order);
		return newOrder.getOrderId();
	}

	@Override
	public Integer cancelOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
		return orderId;
	}

}
