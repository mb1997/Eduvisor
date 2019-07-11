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
		if(request.getSession().getAttribute("user") == null) {
			model.addAttribute("loggedinuser", new String("Please Login first."));
			return "redirect:";
		}
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
	public String post(@Valid @ModelAttribute("question") Post post, BindingResult bindingResult, HttpServletRequest request, Model model) {
		if(request.getSession().getAttribute("user") == null) {
			model.addAttribute("loggedinuser", new String("Please Login first."));
			return "redirect:";
		}
		else if(bindingResult.hasErrors()) {
			List<String> categories = areaservice.listOfInterests();
			model.addAttribute("categories", categories);
			model.addAttribute("errors", bindingResult);
			return "ask_question";
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
	
	//View post
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
	
	//update post
	@RequestMapping(value = "/updatepost", method = RequestMethod.GET)
	public String updatePostPage(@RequestParam("s") String id, Model model, HttpServletRequest request) {
		
		// check if user logged in or not.
		if(request.getSession().getAttribute("user") == null) {
			model.addAttribute("postError", new String("Please login first."));
			return "redirect:";
		}
		
		List<String> categories = areaservice.listOfInterests();
		// fetch whole post data by given id in url.
		model.addAttribute("post", postService.onePost(id));
		model.addAttribute("categories", categories);
		return "update_post";
	}
	
	@RequestMapping(value = "/updatepost", method = RequestMethod.POST)
	public String updatePost(@RequestParam("s") String id, @Valid @ModelAttribute("post") Post post, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("user") == null) {
			model.addAttribute("loggedinuser", new String("Please login first."));
			return "redirect:";
		}
		// Check : Title and description cannot be blank.
		if(post.getDescription() == "" || post.getTitle()== "" || post.getCategory() == "") {
			return "redirect:updatepost?s="+id;
		}
		Post post1 = postService.onePost(id);
		post.setId(id);
		User user = (User) request.getSession().getAttribute("user"); 
		post.setEmail(user.getEmail());
		Post post2 = postService.updatepost(post,post1);
		
		// Check if any error occurs in updating.
		if(post2 == null) {
			return "view_post";
		}
		model.addAttribute("postUpdateSuccess", new String("Refresh your feed!"));
		return "redirect:postDetail?s="+id;
	}
	
	//Delete post
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	  public String deleteById(@RequestParam("id") String id, Post post,HttpServletRequest request)
	  {
		  if(request.getSession().getAttribute("user") == null) 
		  {
			   return "redirect:login";
		  } 
		  else
		  {
			  postService.deletePost(id);
			  return "redirect:view_post";
		  }
		  
	  }
}
