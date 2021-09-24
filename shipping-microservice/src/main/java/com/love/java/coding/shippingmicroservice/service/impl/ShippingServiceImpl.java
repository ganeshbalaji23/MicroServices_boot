package com.love.java.coding.shippingmicroservice.service.impl;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.java.coding.shippingmicroservice.entity.ShippingEntity;
import com.love.java.coding.shippingmicroservice.repository.ShippingRepository;
import com.love.java.coding.shippingmicroservice.service.ShippingService;

@Service
public class ShippingServiceImpl implements ShippingService {
	
	@Autowired
	private ShippingRepository shippingRepository;

	@Override
	public Set<ShippingEntity> getAllShipments(Integer userId) {
		return shippingRepository.findAllByUserId(userId);
	}

	@Override
	public ShippingEntity getShippmentDetails(Integer orderId) {
		return shippingRepository.findByOrderId(orderId);
	}

	@Override
	public ShippingEntity newOrder(ShippingEntity entity) {
		
		entity.setShippingId(UUID.randomUUID().hashCode());
		
		String paymentStatus = processPayment();
		entity.setPaymentStatus(paymentStatus);
		entity.setShippingStatus(paymentStatus.equals("Success")?"Shipped":"Not Shipped");
		
		ShippingEntity newShipment =  shippingRepository.save(entity);
		return newShipment;
	}

	@Override
	public Integer cancelByOrderId(Integer orderId) {
		shippingRepository.deleteByOrderId(orderId);
		return orderId;
	}
	
	public String processPayment() {
		return new Random().nextBoolean() ? "Success" : "Failed";
	}

}
