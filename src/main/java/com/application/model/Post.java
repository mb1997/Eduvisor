package com.application.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
public class Post {
	@Id
	private String id;
	
	@NotBlank(message = "Please enter title")
	private String title;
	
	@NotBlank(message = "Please enter description")
	private String description;
	
	@NotBlank(message = "Please select appropriate category")
	private String Category;
	
	private String email;
	private LocalDate postedDate;
	
	public String get_id() {
		return id;
	}
	public void set_id(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate localDate) {
		this.postedDate = localDate;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
}
