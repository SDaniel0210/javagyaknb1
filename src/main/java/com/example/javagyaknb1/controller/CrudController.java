package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.model.CrudLabdarugo;
import com.example.javagyaknb1.repository.CrudLabdarugoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;

@Controller
public class CrudController {

    private final CrudLabdarugoRepository repo;

    public CrudController(CrudLabdarugoRepository repo) {
        this.repo = repo;
    }

    // LISTÁZÁS
    @GetMapping("/crud")
    public String crudList(Model model) {
        var lista = repo.findAll()
                .stream()
                .sorted(Comparator.comparingLong(CrudLabdarugo::getId).reversed())
                .toList();
        model.addAttribute("crudJatekosok", lista);
        return "crud";
    }

    // HOZZÁADÁS
    @PostMapping("/crud")
    public String create(CrudLabdarugo j) {
        var now = LocalDateTime.now();
        j.setCreatedAt(now);
        j.setUpdatedAt(now);
        repo.save(j);
        return "redirect:/crud";
    }

    // MÓDOSÍTÁS
    @PostMapping("/crud/{id}/update")
    public String update(@PathVariable Integer id, CrudLabdarugo form) {
        var j = repo.findById(id).orElseThrow();
        j.setNev(form.getNev());
        j.setMezszam(form.getMezszam());
        j.setPoszt(form.getPoszt());
        j.setCsapat(form.getCsapat());
        j.setErtek(form.getErtek());
        j.setKor(form.getKor());
        j.setUpdatedAt(LocalDateTime.now());

        repo.save(j);
        return "redirect:/crud";
    }

    // TÖRLÉS
    @PostMapping("/crud/{id}/delete")
    public String delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/crud";
    }
}
