package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showPage(UserDTO userDTO) {
        return "registration";
    }

    @PostMapping
    public String addUser(@Valid @ModelAttribute UserDTO userDTO,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.addUser(userDTO);
        return "redirect:/";
    }
}
