package com.application.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.model.User;
import com.application.repository.UserRepository;

@Service
public class UserRepoService implements UserDetailsService {

	@Autowired
	public UserRepository userrepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	  public User findUserByEmail(String email) {
		    return userrepository.findByEmail(email);
	  }
	  
	  public void saveUser(User user) {
		    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		    userrepository.save(user);
	  }
	  
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User user = userrepository.findByEmail(email);

		    if(user == null) {
		      throw new UsernameNotFoundException("User not found");
		    }

		    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		    return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(User user, List<SimpleGrantedAuthority> authorities) {
		 return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
