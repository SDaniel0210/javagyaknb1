package com.example.javagyaknb1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "fooldal";
    }

    @GetMapping("/kapcsolat")
    public String kapcsolat() {
        return "kapcsolat";
    }

    @GetMapping("/bejelentkezes")
    public String login() {
        return "login";
    }

    @GetMapping("/regisztracio")
    public String register() {
        return "regisztracio";
    }

}

