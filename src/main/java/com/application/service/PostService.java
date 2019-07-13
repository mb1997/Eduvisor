package com.application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Comment;
import com.application.model.Post;
import com.application.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	public PostRepository postrepository;

	public List<Post> allPost() {
		return (List<Post>) postrepository.findAll();
	}
	
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
	
	public Post updatepost(Post post, Post post1) {
		if(!(post1.getTitle().equalsIgnoreCase(post.getTitle())) || 
				(post1.getDescription().equalsIgnoreCase(post.getDescription()) || 
						(post1.getCategory().equals(post.getCategory())))) {
			post1.setTitle(post.getTitle());
			post1.setCategory(post.getCategory());
			post1.setDescription(post.getDescription());
			LocalDateTime localDateTime = LocalDateTime.now();
			LocalDate localDate = localDateTime.toLocalDate();
			post1.setPostedDate(localDate);
		}
		return setposts(post1);
	}

	public Post onePost(String id) {
		Optional<Post> ans = postrepository.findById(id);
		List<Post> res = new ArrayList<>();
		if (ans.isPresent())
			res.add(ans.get());
		return res.get(0);
	}
	
	public Post comment(Post post, Comment comment) {

		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDate localDate = localDateTime.toLocalDate();
		comment.setPostedDate(localDate);
		if(post.getComments() == null) {
			List<Comment> clist = new ArrayList<>();
			clist.add(comment);
			post.setComments(clist);
		}
		else {
			List<Comment> clist = post.getComments();
			clist.add(comment);
			post.setComments(clist);
		}
		return postrepository.save(post);
	}
	
	public void deletePost(String id)
	{
		postrepository.deleteById(id);
	}
	
	
	public List<Post> filterFunction(List<String> name) {
		return postrepository.findByCategoryIn(name);
	}
}
