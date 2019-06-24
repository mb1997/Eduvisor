package com.application.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Login;
import com.application.model.User;
import com.application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean create(User user) {
		user.setTokenID(UUID.randomUUID().toString());
		User user1 = userRepository.save(user);
		if(user1 == null) 
			return false;
		else
			return true;
	}
	
	public User getUser(Login user) {
		User user1 = userRepository.findByEmail(user.getEmail(), user.getPassword());
		return user1;
	}
	
}
