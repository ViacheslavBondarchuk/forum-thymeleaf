package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String showPage() {
		return "registration";
	}

	@PostMapping
	public String addUser(@Validated @ModelAttribute UserDTO userDTO){
		userService.addUser(userDTO);
		return "redirect:/";
	}
}
