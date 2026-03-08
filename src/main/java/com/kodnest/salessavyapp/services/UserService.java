package com.kodnest.salessavyapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kodnest.salessavyapp.entities.User;
import com.kodnest.salessavyapp.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public User registerUser(User user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new RuntimeException("Username already exists");
		}
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}
}
