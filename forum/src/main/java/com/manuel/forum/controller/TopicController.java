package com.manuel.forum.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manuel.forum.model.User;
import com.manuel.forum.service.BaseService;

@RestController
public class TopicController {

	@Autowired
	private BaseService<User> bs;

	@CrossOrigin(origins = "http://localhost:4200")  
	@GetMapping("/test")
	public List<User> test() throws Exception {
		return bs.findAll();
	}

}
