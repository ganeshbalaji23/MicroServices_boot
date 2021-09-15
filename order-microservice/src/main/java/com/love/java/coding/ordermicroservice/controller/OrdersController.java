package com.love.java.coding.ordermicroservice.controller;

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

import com.love.java.coding.ordermicroservice.entity.OrderEntity;
import com.love.java.coding.ordermicroservice.service.OrderService;

@RestController
@RequestMapping("/users/orders")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	//getOrders
	@GetMapping("/getall")
	public ResponseEntity<Set<OrderEntity>> getAllOrders(@RequestParam Integer userId) {
		Set<OrderEntity> allUserOrders = orderService.getAllOrders(userId);
		return ResponseEntity.status(HttpStatus.OK).body(allUserOrders);
	}
	
	@GetMapping("/get/{order}")
	public ResponseEntity<OrderEntity> getOrderById(@PathVariable("order") Integer orderId) {
		OrderEntity orderSelected = orderService.getOrder(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(orderSelected);
	}
	
	//addOrders
	@PostMapping("/add")
	public ResponseEntity<Integer> createOrder(@RequestParam OrderEntity entity) {
		Integer newOrderId = orderService.newOrder(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(newOrderId);
	}
	
	//cancelOrders
	@DeleteMapping("/cancel")
	public ResponseEntity<Integer> cancelOrder(@RequestParam Integer orderId) {
		Integer newOrderId = orderService.cancelOrder(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(newOrderId);
	}
	
}
