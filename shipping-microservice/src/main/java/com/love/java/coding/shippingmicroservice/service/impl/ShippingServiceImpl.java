package com.love.java.coding.shippingmicroservice.service.impl;

import java.util.Set;

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
	public Integer newOrder(ShippingEntity entity) {
		ShippingEntity newShipment =  shippingRepository.save(entity);
		return newShipment.getShippingId();
	}

	@Override
	public Integer cancelByOrderId(Integer orderId) {
		shippingRepository.deleteByOrderId(orderId);
		return orderId;
	}

}
