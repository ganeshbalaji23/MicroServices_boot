package com.love.java.coding.userdetails.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "t_user_payment")
public class PaymentEntity {
	
	@Id
	@Column(name = "user_payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY/* , generator = "paySeqGen" */)
	//@SequenceGenerator(name = "paySeqGen", sequenceName = "paySeq", initialValue = 1001, allocationSize = 100)
	private Integer userPaymentId;

	/*
	 * @Column(name = "user_id")
	 * 
	 * @NonNull private BigInteger userId;
	 */

	@Column(name = "payment_type")
	@NonNull
	private String paymentType;

	@Column(name = "provider")
	private String provider;

	@Column(name = "account_no")
	private BigInteger accountNo;

	@Column(name = "expiry")
	private String expiry;

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	 

	public Integer getUserPaymentId() {
		return userPaymentId;
	}

	public void setUserPaymentId(Integer userPaymentId) {
		this.userPaymentId = userPaymentId;
	}

	/*
	 * public BigInteger getUserId() { return userId; }
	 * 
	 * public void setUserId(BigInteger userId) { this.userId = userId; }
	 */
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public BigInteger getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(BigInteger accountNo) {
		this.accountNo = accountNo;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	 	
}
