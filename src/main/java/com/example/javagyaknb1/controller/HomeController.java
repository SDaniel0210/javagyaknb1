package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "fooldal";
    }

    @GetMapping("/bejelentkezes")
    public String login() {
        return "bejelentkezes";
    }

    @GetMapping("/regisztracio")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "regisztracio";
    }

}

