package com.david.myBlogRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.myBlogRestAPI.entity.User;
import com.david.myBlogRestAPI.service.UserRestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserRestController {
	private UserRestService userRestService;

	@Autowired
	public UserRestController(UserRestService userRestService) {
		this.userRestService = userRestService;
	}

	@GetMapping("/data")
	public String getData() {
		return "hello";
	}

	@GetMapping("/userData")
	public List<User> hibernate() {
		List<User> theUsers = userRestService.getUsers();
		return theUsers;
	}

}
