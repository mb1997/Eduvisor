package com.application.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	@Id
	@NotBlank(message = "Email must not be empty")
	private String email;

	@NotBlank(message = "Name must not be empty")
	@Pattern(regexp = "[A-Za-z ]*", message = "Name must only contain alphabets and spaces")
	private String name;

	@NotBlank(message = "Contact number must not be empty")
	@Size(min = 10, max = 10, message = "Contact number must be of 10 digits")
	@Pattern(regexp = "^[^0].*", message="Contact number must not start with 0")
	private String contactNumber;

	@NotBlank(message = "Please select appropriate profession")
	private String profession;

	@NotBlank(message = "Password must not be empty")
	@Pattern(regexp ="(?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,40}", message = "Password must contain a lowercase, a uppercase, a digit and it must be greater than 8 characters")
	private String password;

	private boolean isVerified = false;
	private String tokenID = null;

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
