package com.love.java.coding.shippingmicroservice.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.love.java.coding.shippingmicroservice.entity.ShippingEntity;
import com.love.java.coding.shippingmicroservice.service.ShippingService;

@RestController
@RequestMapping("/users/orders/shipping")
public class ShippingController {
	
	@Autowired
	private ShippingService shippingService;
	
	//getOrders
	@GetMapping("/getall")
	public ResponseEntity<Set<ShippingEntity>> getAllShipments(@RequestParam Integer userId) {
		Set<ShippingEntity> allShipments = shippingService.getAllShipments(userId);
		return ResponseEntity.status(HttpStatus.OK).body(allShipments);
	}
	
	@GetMapping("/track/{order}")
	public ResponseEntity<ShippingEntity> trackShipmentByOrder(@PathVariable("order") Integer orderId) {
		ShippingEntity shipmentStatus = shippingService.getShippmentDetails(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(shipmentStatus);
	}
	
	//addOrders
	@PostMapping("/add")
	public ResponseEntity<Integer> createShipmentForOrder(@RequestParam ShippingEntity entity) {
		Integer trackId = shippingService.newOrder(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(trackId);
	}
	
	//cancelOrders
	@DeleteMapping("/cancel/{order}")
	public ResponseEntity<Integer> cancelOrder(@PathVariable("order") Integer orderId) {
		Integer cancelledShipment = shippingService.cancelByOrderId(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(cancelledShipment);
	}

}
