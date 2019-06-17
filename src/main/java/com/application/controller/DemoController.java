package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String Home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
}
