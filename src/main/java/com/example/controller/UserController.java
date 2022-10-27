package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	

	@RequestMapping("/login")
	public ModelAndView login(String username, String pwd) {
		
		System.out.println("inside login() "+username+", "+pwd);
		
		String loginStatus = userService.validateUser(username, pwd);
		
		if(loginStatus.equals("valid")) {
			ModelAndView modelAndView = new ModelAndView("welcomePage");
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("index");
			return modelAndView;
		}
	}
}
