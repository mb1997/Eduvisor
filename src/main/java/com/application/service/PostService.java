package com.application.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Post;
import com.application.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	public PostRepository postrepository;
	
	public Post setposts(Post post) {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDate localDate = localDateTime.toLocalDate();
		post.setPostedDate(localDate);
		postrepository.save(post);
		return post;
	}
	public List<Post> display(String email) {
		return postrepository.findByEmail(email);
	}
}
