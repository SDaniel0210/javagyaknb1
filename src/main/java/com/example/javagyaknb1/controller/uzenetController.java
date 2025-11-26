package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.model.Uzenet;
import com.example.javagyaknb1.model.User;
import com.example.javagyaknb1.repository.UserRepository;
import com.example.javagyaknb1.config.UzenetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class uzenetController {
    @Autowired private UserRepository userRepo;
    @Autowired private UzenetService uzenetService;

    @GetMapping("/kapcsolat")
    public String kapcsolat(Model model) {
        model.addAttribute("formUzenet", new Uzenet());
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat")
    public String kuldes(@ModelAttribute("formUzenet") Uzenet beUzenet,
                         @AuthenticationPrincipal UserDetails currentUser) {

        User user = userRepo.findByEmail(currentUser.getUsername()).get();
        beUzenet.setUser(user);

        uzenetService.save(beUzenet);

        return "redirect:/kapcsolat?sikeres";
    }

    @GetMapping("/uzenet")
    public String sajatUzenetek(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = userRepo.findByEmail(currentUser.getUsername()).orElseThrow();
        model.addAttribute("uzenetek", uzenetService.getUserUzenetek(user));
        return "uzenet";
    }

    @PostMapping("/uzenet/{id}/delete")
    public String delete(@PathVariable int id, @AuthenticationPrincipal UserDetails currentUser) {

        Uzenet u = uzenetService.findById(id).orElseThrow();

        // csak a saját üzenetét törölhesse
        if (!u.getUser().getEmail().equals(currentUser.getUsername())) {
            return "redirect:/uzenet?hiba";
        }

        uzenetService.delete(id);
        return "redirect:/uzenet?torolve";
    }

    @GetMapping("/admin")
    public String adminUzenetek(Model model) {
        model.addAttribute("uzenetek", uzenetService.getAllUzenetek());
        return "admin";
    }

    @PostMapping("/admin/{id}/delete")
    public String adminDelete(@PathVariable int id) {
        uzenetService.delete(id);
        return "redirect:/admin?torolve";
    }
}
