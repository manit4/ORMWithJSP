package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/registrationPage")
	public ModelAndView registrationPage() {
		
		ModelAndView modelAndView = new ModelAndView("registrationPage");
		
		return modelAndView;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(String username, String password, String firstName, String lastName, String email) {
		
		System.out.println("inside register() "+username+", "+password+", "+firstName+", "+lastName+", "+email);
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		User user = new User(username, password, firstName, lastName, email);
		
		userService.addUser(user);
		
		return modelAndView;
	}

}
