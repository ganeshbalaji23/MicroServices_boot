package com.love.java.coding.userdetails.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.love.java.coding.userdetails.entity.PaymentEntity;
import com.love.java.coding.userdetails.entity.UserEntity;
import com.love.java.coding.userdetails.repository.PaymentDetailsRepository;
import com.love.java.coding.userdetails.service.UserService;

@RestController
@RequestMapping("/userpayment")
public class UserPaymentController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;
	
	
	@GetMapping("/getpayments")
	public ResponseEntity<Set<PaymentEntity>> getUserPayments(@RequestParam String userName) {
		
		UserEntity user = userService.getUserDetails(userName);
		if(user != null) {
			Set<PaymentEntity> payment = paymentDetailsRepository.findAllByUserId(user);
			return ResponseEntity.status(HttpStatus.OK).body(payment);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@PostMapping("/addpayment{userName}")
	public ResponseEntity<String> addUserPayment(@PathVariable String userName, @RequestBody PaymentEntity userPayment) {
		UserEntity user = userService.getUserDetails(userName);
		if(user != null) {
			userPayment.setUserId(user);
			paymentDetailsRepository.save(userPayment);
			//user.getPayments().add(userPayment);
			//userService.saveUser(user);
			return ResponseEntity.status(HttpStatus.OK).body("Payment mode added");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@DeleteMapping("/removepayment{userName}")
	public ResponseEntity<String> deleteUserPayment(@PathVariable String userName, @RequestParam Integer paymentId ) {
		UserEntity user = userService.getUserDetails(userName);
		if(user != null) {
			paymentDetailsRepository.deleteById(paymentId);
			//PaymentEntity removePayment = user.getPayments().stream().filter(val -> val.getUserPaymentId() == paymentId).findAny().get();
			//user.getPayments().remove(removePayment);
			//userService.saveUser(user);
			return ResponseEntity.status(HttpStatus.OK).body("Payment mode removed");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
