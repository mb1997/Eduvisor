package com.application.model;


import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Id
	private String email;
	private String password;
	private String tokenId;
	private String name;
	private String contactNumber;
	private String profession;
	private boolean Isverified = false;
	
	
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId() {
		Random rand = new Random();
		tokenId = Integer.toString(rand.nextInt(100000));
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
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
	
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
	public boolean isIsverified() {
		return Isverified;
	}
	public void setIsverified(boolean isverified) {
		Isverified = isverified;
	}
	
}
