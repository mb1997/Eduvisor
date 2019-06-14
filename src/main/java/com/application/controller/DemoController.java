package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/login")
	public String Demo() {
		
		return "redirect:/WEB-INF/jsp/login.jsp";
		
	}
	
}
