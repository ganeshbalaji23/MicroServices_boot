package com.love.java.coding.userdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.love.java.coding.userdetails.entity.UserEntity;
import com.love.java.coding.userdetails.model.User;
import com.love.java.coding.userdetails.service.UserService;

@RestController
@RequestMapping("/userdetails")
public class UserController {
	
	@Autowired
	private UserService userService;


	@PostMapping("/adduser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		String userName = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(userName+" created");
	}

	@DeleteMapping("/deleteuser")
	public ResponseEntity<String> deleteUser(@RequestParam String userName) {
		boolean isUserDeleted = userService.deleteUser(userName);
		
		if (isUserDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body("User deleted");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available or already deleted");
		}
	}

	@PutMapping("/updateuser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		String userName = userService.updateUser(user);
		if (userName != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userName + " updated");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(userName + " not updated. Try later");
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<UserEntity> getUser(@RequestParam String userName) {
		UserEntity user = userService.getUserDetails(userName);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
