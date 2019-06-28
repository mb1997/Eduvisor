package com.application.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class Login {

	@Id
	@NotBlank(message="Email must not be empty")
	private String email;
	
	@NotBlank(message="Password must not be empty")
	@Pattern(regexp ="(?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,40}", message = "Invalid password")
	private String password;

	private boolean isVerified;
	private String tokenID;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getTokenID() {
		return tokenID;
	}
	public void setTokenID(String tokenID) {
		this.tokenID = tokenID;
	}
	
	
}
