package com.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.model.Comment;
import com.application.model.Post;
import com.application.model.User;
import com.application.service.AreaOfInterestService;
import com.application.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private AreaOfInterestService areaservice;
	
	@RequestMapping(value="/addQuestion", method = RequestMethod.GET)
	public String viewAllPosts(Model model, HttpServletRequest request) {
		List<String> categories = areaservice.listOfInterests();
		model.addAttribute("question", new Post());
		model.addAttribute("categories", categories);
		return "/ask_question";
	}
	
//	@RequestMapping(value="/viewAllposts", method = RequestMethod.GET)
//	public String viewPost(Model model, HttpServletRequest request) {
//		if(request.getSession().getAttribute("user") == null) {
//			return "redirect:";
//		}
//		return "viewAllposts";
//	}
	
	@RequestMapping(value="/addQuestion", method = RequestMethod.POST)
	public String post(@Valid @ModelAttribute("post") Post post, BindingResult bindingResult, HttpServletRequest request, Model model) {
		if(request.getSession().getAttribute("user") == null) {
			model.addAttribute("loggedinuser", new String("Please Login first."));
			return "redirect:";
		}
		// set session email to post's email
		User user = (User) request.getSession().getAttribute("user"); 
		post.setEmail(user.getEmail());
		
		// save post to database
		Post post2 = postService.setposts(post);
		
		// if post isn't saved then show error
		if(post2 == null) {
			model.addAttribute("post", new Post());
			model.addAttribute("postError", new String("Unexpected Error! Please try again later."));
			return "redirect:";
		}
		// Tell user to refresh their feed to view their post.
		model.addAttribute("postSuccess", new String("Refresh your feed!"));
		return "index";
	}
	
	@RequestMapping(value="/view_post",method = RequestMethod.GET)
	public String viewPost(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null) {
			return "redirect:";
		}
		else
		{
			User user = (User) request.getSession().getAttribute("user");
			model.addAttribute("postValue",postService.display(user.getEmail()));
			return "view_post";
		}
	}
	
	@RequestMapping(value = "/postDetail", method = RequestMethod.GET)
	public String postDetailPage(@RequestParam("s") String id, Model model) {
		model.addAttribute("post", postService.onePost(id));
		model.addAttribute("commentform", new Comment());
		System.out.println("GET REQUEST");
		return "postDetail";
	}
	
	@RequestMapping(value = "/postDetail", method = RequestMethod.POST)
	public String comment(@RequestParam("s") String id, @Valid @ModelAttribute("commentform") Comment comment, Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null) {
			return "redirect:";
		}
		Post post = postService.onePost(id);
		User user = (User) request.getSession().getAttribute("user");
		comment.setEmail(user.getEmail());
		post = postService.comment(post, comment);
		if(post == null) {
			model.addAttribute("message", new String("Unexpected error! Please try again later"));
			return "postDetail?s="+id;
		}
		else {
			return "redirect:postDetail?s="+id;
		}
	}
}
