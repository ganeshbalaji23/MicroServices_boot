package com.love.java.coding.userdetails.model;

import java.math.BigInteger;

public class User {

	private String userName;

	private String password;

	private String firstName;

	private String lastName;

	private BigInteger mobileNo;

	private UserAddress address;

	private UserPayment payment;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public BigInteger getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(BigInteger mobileNo) {
		this.mobileNo = mobileNo;
	}

	public UserPayment getPayment() {
		return payment;
	}

	public void setPayment(UserPayment payment) {
		this.payment = payment;
	}

}
