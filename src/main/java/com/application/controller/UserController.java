package com.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.application.model.Login;
import com.application.model.User;
import com.application.service.UserService;

@Controller
public class UserController implements WebMvcConfigurer {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String loginPage(Model model) {
		model.addAttribute("login", new User());
		model.addAttribute("register", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("login") Login user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("error", bindingResult);
			model.addAttribute("register", new User());
			return "login";
		}
		User user1 = userService.getUser(user);
		if(user1 == null) {
			model.addAttribute("register", new User());
			return "login";
		}
		else {
			if(user1.isVerified() == true) {
				return "redirect:";
			}
			else {
				model.addAttribute("register", new User());
				return "login";
			}
		}
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("login", new User());
		model.addAttribute("register", new User());
		return "login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("register") User user, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("error", bindingResult);
			model.addAttribute("login", new User());
			return "login";
		}
		if(userService.create(user) == true)		
			return "redirect:";
		else
			return "redirect:login";
	}
	
}
