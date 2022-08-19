package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.User;
import com.luv2code.springboot.thymeleafdemo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService theuserService) {
		userService = theuserService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listusers(Model theModel) {

		// get users from db
		List<User> theUsers = userService.findAll();

		// add to the spring model
		theModel.addAttribute("users", theUsers);

		return "users/list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		User theuser = new User();

		theModel.addAttribute("user", theuser);

		return "users/user-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {

		// get the user from the service
		User theUser = userService.findById(theId);

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);

		// send over to our form
		return "users/user-form";
	}

	@PostMapping("/save")
	public String saveuser(@ModelAttribute("user") User theUser) {

		// save the user
		userService.save(theUser);

		// use a redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("userId") int theId) {
		// delete the comment
		userService.deleteById(theId);

		return "redirect:/users/list";
	}

}
