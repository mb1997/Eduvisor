package com.application.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.application.model.Login;
import com.application.model.User;
import com.application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) {
		user.setTokenID(UUID.randomUUID().toString());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User user1 = userRepository.save(user); 
		return user1;
	}
	
	public User getUser(Login user) {
		User user1 = userRepository.findByEmail(user.getEmail(), user.getPassword());
		return user1;
	}
	
	public User getUser(User user) {
		User user1 = userRepository.findByEmail(user.getEmail());
		return user1;
	}
	
	public User updateAreaOfInterest(User user1, String[] interest) {
		user1.setAreaOfInterest(interest);
		return userRepository.save(user1);
	}
	
	public boolean checkAoI(User user) {
		//userRepository.findByAreaOfInterestExists(true);
		return true;
	}
}
