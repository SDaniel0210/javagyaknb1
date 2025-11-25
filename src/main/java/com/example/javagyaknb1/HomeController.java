package com.example.javagyaknb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "fooldal";
    }

    @GetMapping("/adatbazis")
    public String adatbazis() {
        return "adatbazis";
    }

    @GetMapping("/kapcsolat")
    public String kapcsolat() {
        return "kapcsolat";
    }

    @GetMapping("/diagram")
    public String diagram() {
        return "diagram";
    }

    @GetMapping("/crud")
    public String crud() {
        return "crud";
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

