package com.love.java.coding.userdetails.model;

import java.math.BigInteger;

public class UserAddress {
	
	//private String userName;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String postalCode;
	
	private String country;
	
	private BigInteger mobile;
	
	private boolean isPrimaryAddress;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getMobile() {
		return mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public boolean isPrimaryAddress() {
		return isPrimaryAddress;
	}

	public void setPrimaryAddress(boolean isPrimaryAddress) {
		this.isPrimaryAddress = isPrimaryAddress;
	}
	
}
