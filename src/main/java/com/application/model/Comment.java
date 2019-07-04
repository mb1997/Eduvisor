package com.application.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
public class Comment {

	@Id
	private String id;
	
	private String comment;
	
	private String email;
	
	private LocalDate postedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", email=" + email + ", postedDate=" + postedDate + "]";
	}
	
}
