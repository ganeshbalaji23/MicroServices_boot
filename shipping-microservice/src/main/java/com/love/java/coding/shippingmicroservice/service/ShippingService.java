package com.love.java.coding.shippingmicroservice.service;

import java.util.Set;

import com.love.java.coding.shippingmicroservice.entity.ShippingEntity;

public interface ShippingService {

	Set<ShippingEntity> getAllShipments(Integer userId);

	ShippingEntity getShippmentDetails(Integer orderId);

	ShippingEntity newOrder(ShippingEntity entity);

	Integer cancelByOrderId(Integer orderId);

}
