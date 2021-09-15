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

import com.love.java.coding.userdetails.entity.AddressEntity;
import com.love.java.coding.userdetails.entity.UserEntity;
import com.love.java.coding.userdetails.repository.UserAddressRepository;
import com.love.java.coding.userdetails.service.UserService;

@RestController
@RequestMapping("/useraddress")
public class UserAddressController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAddressRepository userAddressRepository;

	@GetMapping("/getaddress")
	public ResponseEntity<Set<AddressEntity>> getUserAddresses(@RequestParam String userName) {
		UserEntity user = userService.getUserDetails(userName);

		if (user != null) {
			//Integer userId = user.getUserId();
			return ResponseEntity.status(HttpStatus.OK).body(userAddressRepository.findAllByUserId(user));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

	@PostMapping("/addaddress{userName}")
	public ResponseEntity<String> addUserAddress(@PathVariable String userName, @RequestBody AddressEntity userAddress) {
		UserEntity user = userService.getUserDetails(userName);
		if (user != null) {
			//user.getAddresses().add(userAddress);
			userAddress.setUserId(user);
			userAddressRepository.save(userAddress);
			return ResponseEntity.status(HttpStatus.OK).body("New Address created for " + user.getUserName());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userName + " not found");
	}

	@DeleteMapping("/deleteaddress{userName}")
	public ResponseEntity<String> deleteUserAddress(@PathVariable String userName, @RequestParam Integer addressId) {
		UserEntity user = userService.getUserDetails(userName);
		if (user != null) {
			userAddressRepository.deleteById(addressId);
			return ResponseEntity.status(HttpStatus.OK).body("Existing Address deleted for " + user.getUserName());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userName + " not found");
	}

}
