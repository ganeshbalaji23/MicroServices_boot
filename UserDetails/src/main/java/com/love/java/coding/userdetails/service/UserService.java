package com.love.java.coding.userdetails.service;

import com.love.java.coding.userdetails.entity.UserEntity;
import com.love.java.coding.userdetails.model.User;

public interface UserService {
	
	public String addUser(User user);
	
	public String updateUser(User user);
	
	public UserEntity getUserDetails(String userName);

	public boolean deleteUser(String userName);

	public UserEntity saveUser(UserEntity user);
	
	

}
