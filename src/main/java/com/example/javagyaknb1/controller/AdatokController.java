package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.repository.LabdarugoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdatokController {

    private final LabdarugoRepository labdarugoRepository;

    public AdatokController(LabdarugoRepository labdarugoRepository) {
        this.labdarugoRepository = labdarugoRepository;
    }

    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {
        var labdarugok = labdarugoRepository.findAllWithKlubAndPosztSorted();
        model.addAttribute("labdarugok", labdarugok);
        return "adatok";
    }
}
