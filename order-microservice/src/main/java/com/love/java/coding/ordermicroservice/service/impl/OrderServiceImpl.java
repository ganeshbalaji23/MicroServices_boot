package com.love.java.coding.ordermicroservice.service.impl;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.java.coding.ordermicroservice.client.ShippingClient;
import com.love.java.coding.ordermicroservice.entity.OrderEntity;
import com.love.java.coding.ordermicroservice.model.ShippingEntity;
import com.love.java.coding.ordermicroservice.model.TransactionRequest;
import com.love.java.coding.ordermicroservice.model.TransactionResponse;
import com.love.java.coding.ordermicroservice.repository.OrderRepository;
import com.love.java.coding.ordermicroservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ShippingClient shippingClient;

	@Override
	public Set<OrderEntity> getAllOrders(Integer userId) {
		return orderRepository.findAllByCustomerId(userId);
	}

	@Override
	public OrderEntity getOrder(Integer orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public TransactionResponse newOrder(TransactionRequest request) {
		
		OrderEntity newOrderEntity = request.getOrder();
		newOrderEntity.setOrderId(UUID.randomUUID().hashCode());
		newOrderEntity.setOrderDate(LocalDate.now());
		OrderEntity createdOrder = orderRepository.save(newOrderEntity);
		
		
		ShippingEntity shippingEntity = request.getShipping();
		shippingEntity.setUserId(newOrderEntity.getCustomerId());
		shippingEntity.setOrderId(newOrderEntity.getOrderId());
		shippingEntity.setShippingCost(newOrderEntity.getQuantity() * newOrderEntity.getPrice());
		shippingEntity.setOrderCreatedDate(newOrderEntity.getOrderDate());
		ShippingEntity createdShippingEntity = shippingClient.createShipmentForOrder(shippingEntity);
		
		createdOrder.setStatus(createdShippingEntity.getPaymentStatus());
		createdOrder = orderRepository.save(createdOrder);
		
		TransactionResponse response = new TransactionResponse();
		response.setOrder(createdOrder);
		response.setShippingId(createdShippingEntity.getShippingId());
		response.setShippingCost(createdShippingEntity.getShippingCost());
		response.setMessage(createdShippingEntity.getShippingStatus());
		
		return response;
	}

	@Override
	public Integer cancelOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
		return orderId;
	}

}
