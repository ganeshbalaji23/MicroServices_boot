package com.love.java.coding.userdetails.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.java.coding.userdetails.entity.AddressEntity;
import com.love.java.coding.userdetails.entity.PaymentEntity;
import com.love.java.coding.userdetails.entity.UserEntity;
import com.love.java.coding.userdetails.model.User;
import com.love.java.coding.userdetails.model.UserAddress;
import com.love.java.coding.userdetails.model.UserPayment;
import com.love.java.coding.userdetails.repository.UserRepository;
import com.love.java.coding.userdetails.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String addUser(User user) {
		UserEntity userEntity = setUserData(user);
		UserEntity savedUser = userRepository.save(userEntity);
		savedUser.setAddresses(setAddresses(Arrays.asList(user.getAddress()), savedUser));
		savedUser.setPayments(setPayments(Arrays.asList(user.getPayment()), savedUser));
		userRepository.save(savedUser);
		return savedUser.getUserName();
		
	}

	@Override
	public String updateUser(User user) {
		boolean isUserAvailable = checkUserAvailability(user.getUserName());
		UserEntity modifiedUser = setUserData(user);
		if(isUserAvailable) {
			UserEntity updatedUser = userRepository.save(modifiedUser);
			return updatedUser.getUserName();
		}
		
		return null;
	}

	@Override
	public boolean deleteUser(String userName) {
		boolean isUserAvailable = checkUserAvailability(userName);
		
		if(isUserAvailable) {
			userRepository.deleteByUserName(userName);
			isUserAvailable = checkUserAvailability(userName);
		}
		
		return isUserAvailable;
	}

	@Override
	public UserEntity getUserDetails(String userName) {
		UserEntity userByName = userRepository.findByUserName(userName).get();
		userByName.setPassword(null);
		return userByName;
	}
	
	private Set<PaymentEntity> setPayments(List<UserPayment> payment, UserEntity savedUser) {
		Set<PaymentEntity> payments = payment.stream().map(val -> createPaymentEntity(val,savedUser)).collect(Collectors.toSet());
		return payments;
	}
	

	private PaymentEntity createPaymentEntity(UserPayment payment, UserEntity savedUser) {
		
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setUser(savedUser);
		paymentEntity.setAccountNo(payment.getAccountNo());
		paymentEntity.setExpiry(payment.getExpiry());
		paymentEntity.setPaymentType(payment.getPaymentType());
		paymentEntity.setProvider(payment.getProvider());
		return paymentEntity;
	}

	private Set<AddressEntity> setAddresses(List<UserAddress> address, UserEntity savedUser) {
		
		Set<AddressEntity> addresses = address.stream().map(val -> createAddressEntity(val,savedUser)).collect(Collectors.toSet());
		return addresses;
	}
	
	private AddressEntity createAddressEntity(UserAddress address, UserEntity savedUser) {
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setUser(savedUser);
		addressEntity.setAddressLine1(address.getAddressLine1());
		addressEntity.setAddressLine2(address.getAddressLine2());
		addressEntity.setCity(address.getCity());
		addressEntity.setCountry(address.getCountry());
		addressEntity.setPostalCode(address.getPostalCode());
		addressEntity.setMobile(address.getMobile());
		addressEntity.setPrimaryAddress(true);
		return addressEntity;
	}
	
	private UserEntity setUserData(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setCreatedAt(LocalDate.now());
		userEntity.setMobile(user.getMobileNo());
		return userEntity;
	}
	
	private boolean checkUserAvailability(String userName) {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}

}
