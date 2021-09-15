package com.love.java.coding.userdetails.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_user_address")
public class AddressEntity {
	
	@Id
	@Column(name="user_address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY/* , generator = "addrSeqGen" */)
	//@SequenceGenerator(name = "addrSeqGen", sequenceName = "addrSeq", initialValue = 1001, allocationSize = 100)
	private Integer addressId;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="mobile")
	private BigInteger mobile;
	
	@Column(name="is_primary_address")
	private boolean isPrimaryAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "uid")
	private UserEntity userId;
	
	public Integer getAddressId() {
		return addressId;
	}

	public void Integer(Integer addressId) {
		this.addressId = addressId;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}
	 

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

	/*
	 * public UserEntity getUser() { return user; }
	 * 
	 * public void setUser(UserEntity user) { this.user = user; }
	 */

}
