package com.love.java.coding.ordermicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.love.java.coding.ordermicroservice.model.ShippingEntity;

@FeignClient(name = "shipping-microservice")
public interface ShippingClient {
	
	@PostMapping("/shipping/add")
	public ShippingEntity createShipmentForOrder(@RequestBody ShippingEntity entity);

}
