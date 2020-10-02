package com.manuel.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.expression.Mvc;

import com.manuel.forum.model.User;
import com.manuel.forum.service.BaseService;

@RestController
public class UserController {

	@Autowired
	private BaseService<User> userService;

	@GetMapping("/hello")
	public String test() {
		return "Hello world";
	}
	
	@GetMapping("/login")
	public Object login() {
		return new ModelAndView("login.html");
	}
	
	
	
}
