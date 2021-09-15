package com.love.java.coding.shippingmicroservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_shipping_details")
public class ShippingEntity {

	@Id
	@Column(name = "shipping_id")
	private Integer shippingId;
	
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "shipping_address_id")
	private Integer shippingAddressId;
	
	@Column(name = "shipping_cost")
	private Integer shippingCost;
	
	@Column(name = "billing_address_id")
	private Integer billingAddressId;
	
	@Column(name = "order_created_date")
	private LocalDate orderCreatedDate;
	
	@Column(name = "payment_type_id")
	private Integer paymentId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "shipping_status")
	private String shippingStatus;

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public Integer getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Integer shippingCost) {
		this.shippingCost = shippingCost;
	}

	public Integer getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(Integer billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public LocalDate getOrderCreatedDate() {
		return orderCreatedDate;
	}

	public void setOrderCreatedDate(LocalDate orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
}
