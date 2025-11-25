package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.config.UserService;
import com.example.javagyaknb1.model.User;
import com.example.javagyaknb1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired private UserRepository userRepo;
    @Autowired private UserService userService;


    @PostMapping("/regisztracio")
    public String register(@ModelAttribute User user) {

        String rawPassword = user.getPassword();
        userService.register(user);
        userService.autoLogin(user.getEmail(), rawPassword);
        return "redirect:/";
    }
}