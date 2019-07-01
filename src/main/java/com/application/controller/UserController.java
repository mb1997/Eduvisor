package com.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.application.event.OnRegistrationSuccessEvent;
import com.application.model.Login;
import com.application.model.User;
import com.application.service.NotificationService;
import com.application.service.UserService;

@Controller
public class UserController implements WebMvcConfigurer {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private UserService userService;

	@Autowired
	private NotificationService notificationservice;

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/logout")
	public String logoutFunciton(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") != null)
			request.getSession().setAttribute("user", null);
		return "redirect:";
	}

	@RequestMapping(value = "/login")
	public String loginPage(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") != null) {
			return "redirect:";
		}
		model.addAttribute("login", new Login());
		model.addAttribute("register", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("login") Login user, BindingResult bindingResult, Model model,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", bindingResult);
			model.addAttribute("register", new User());
			return "login";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16); // Strength set as 16
		user.setPassword(encoder.encode(user.getPassword()));
		User user1 = userService.getUser(user);
		if (user1 == null) {
			user.setPassword(null);
			model.addAttribute("register", new User());
			model.addAttribute("loginError", new String("No account with this mail found."));
			return "login";
		} else {
			if (encoder.matches(user.getPassword(), user1.getPassword()) == false) {
				user.setPassword(null);
				model.addAttribute("register", new User());
				model.addAttribute("loginError", new String("Invalid Password"));
				return "login";
			} else if (user1.isVerified() == true) {
				request.getSession().setAttribute("user", user1);
				try {
					if (user1.getAreaOfInterest().length == 0) {
						return "redirect:interest";
					}
				} catch (NullPointerException ex) {
					return "redirect:interest";
				}
				return "redirect:";
			} else {
				user.setPassword(null);
				model.addAttribute("register", new User());
				model.addAttribute("loginError", new String("You are not verified user, so kindly check your mail."));
				return "login";
			}
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("user") != null) {
			return "redirect:";
		}
		model.addAttribute("login", new Login());
		model.addAttribute("register", new User());
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("register") User user, BindingResult bindingResult,
			WebRequest request, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("error", bindingResult);
			model.addAttribute("login", new Login());
			user.setPassword(null);
			return "login";
		}
		if (userService.getUser(user) == null) {
			User registeredUser = userService.create(user);
			if (registeredUser != null) {
				try {
					String appUrl = request.getContextPath();
					eventPublisher
							.publishEvent(new OnRegistrationSuccessEvent(registeredUser, request.getLocale(), appUrl));
				} catch (Exception re) {
					re.printStackTrace();
//					throw new Exception("Error while sending confirmation email");
				}
				model.addAttribute("login", new Login());
				model.addAttribute("registerSuccess", new String(
						"Registered Successfully, Kindly check your mail to verify your account and Login again"));
				return "login";
			} else {
				model.addAttribute("login", new Login());
				user.setPassword(null);
				model.addAttribute("registerError", new String("Unexpected Error! Please try again later."));
				return "login";
			}
		} else {
			model.addAttribute("login", new Login());
			user.setPassword(null);
			model.addAttribute("registerError", new String("Account already exist with corresponding email address."));
			return "login";
		}
	}

	@GetMapping("/confirmRegistration")
	public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {

		User verificationToken = notificationservice.getVerificationToken(token);
		if (verificationToken == null || verificationToken.isVerified() == true) {
			String message = "auth.message.invalidToken";
			model.addAttribute("message", message);
			return "redirect:access-denied";
		}
		verificationToken.setVerified(true);
		verificationToken.setTokenID(null);
		notificationservice.enableRegisteredUser(verificationToken);

		return "redirect:login";
	}

}
