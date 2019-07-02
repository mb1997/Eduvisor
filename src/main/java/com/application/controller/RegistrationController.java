package com.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.application.event.OnRegistrationSuccessEvent;
import com.application.model.User;
import com.application.service.NotificationService;

@RestController
public class RegistrationController {

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private NotificationService notificationservice;
	
	
	@RequestMapping("/signup")
	public String signup() {
		return "please sign up !!!";
	}
	
	// on-click submit... call this function in view!
	
	@RequestMapping(value = "/signup-success", method = RequestMethod.POST)
	public String signupSuccess(@ModelAttribute("user") User user, BindingResult result, WebRequest request, Model model) {
		
		// send a notification
		User registeredUser = new User();
		String userEmail = user.getEmail();
		String userName = user.getName();
		if (result.hasErrors()) {
		    return "registration";
		}
		registeredUser = notificationservice.findUserByEmail(userEmail);
		if(registeredUser!=null) {
		    model.addAttribute("error","There is already an account with this username: " + userName);
		    return "registration";
		}
		registeredUser = notificationservice.registerUser(user);
		
		try {
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationSuccessEvent(registeredUser, request.getLocale(),appUrl));
		}catch(Exception re) {
			re.printStackTrace();
//			throw new Exception("Error while sending confirmation email");
		}
		return "registrationSuccess";
	}
	
//	@GetMapping("/confirmRegistration1")
//	public String confirmRegistration(WebRequest request, Model model,@RequestParam("token") String token) {
//		
//		User verificationToken = notificationservice.getVerificationToken(token);
//		if(verificationToken == null) {
//			String message = "auth.message.invalidToken";
//			model.addAttribute("message", message);
//			return "redirect:access-denied";
//		}
//		verificationToken.setVerified(true);
//		verificationToken.setTokenID(null);
//		notificationservice.enableRegisteredUser(verificationToken);
//		
//		return "User verified!";
//	}
}
