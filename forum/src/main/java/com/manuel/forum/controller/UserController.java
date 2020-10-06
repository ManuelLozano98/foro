package com.manuel.forum.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.manuel.forum.model.User;
import com.manuel.forum.repository.UserRepository;
import com.manuel.forum.service.BaseService;

@RestController
public class UserController {

	@Autowired
	private BaseService<User> userService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/hello")
	public String test() {
		return "Hello world";
	}

	@GetMapping("/login")
	public Object login() {
		return new ModelAndView("login.html");
	}

	@PostMapping("/sign-up")
	public void createUser(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(new BCryptPasswordEncoder().encode(password));
		u.setEmail("test@test.com");
		u.setRegistrationDate(new Date());
		u.setRole("user");
		userService.save(u);
	}

	@GetMapping("/getUser")
	@ResponseBody
	public Optional<User> getUser(@RequestParam(name = "username") String username) {
		return userRepository.getUserByUserName(username);
	}

}
