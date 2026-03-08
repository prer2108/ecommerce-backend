package com.kodnest.salessavyapp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.salessavyapp.entities.User;
import com.kodnest.salessavyapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody User user) {
		
		try {
			User registeredUser = userService.registerUser(user);
			return ResponseEntity.ok(Map.of("message", "User registered sucessfully", "user",registeredUser));
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));
			
		}
	}

}
