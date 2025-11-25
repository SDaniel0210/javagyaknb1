package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.model.CrudLabdarugo;
import com.example.javagyaknb1.repository.CrudLabdarugoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class CrudRestController {

    private final CrudLabdarugoRepository repo;

    public CrudRestController(CrudLabdarugoRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<CrudLabdarugo> getAll() {
        return repo.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public CrudLabdarugo getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // POST - create
    @PostMapping
    public CrudLabdarugo create(@RequestBody java.util.Map<String, Object> body) {

        CrudLabdarugo j = new CrudLabdarugo();

        j.setNev((String) body.get("nev"));
        j.setMezszam((Integer) body.get("mezszam"));
        j.setPoszt((String) body.get("poszt"));
        j.setCsapat((String) body.get("csapat"));
        j.setErtek((Integer) body.get("ertek"));
        j.setKor((Integer) body.get("kor"));

        // időbélyegek
        j.setCreatedAt(java.time.LocalDateTime.now());
        j.setUpdatedAt(java.time.LocalDateTime.now());

        return repo.save(j);
    }


    // PUT - update
    @PutMapping("/{id}")
    public CrudLabdarugo update(@PathVariable Long id, @RequestBody CrudLabdarugo form) {
        CrudLabdarugo j = repo.findById(id).orElseThrow();

        j.setNev(form.getNev());
        j.setMezszam(form.getMezszam());
        j.setPoszt(form.getPoszt());
        j.setCsapat(form.getCsapat());
        j.setErtek(form.getErtek());
        j.setKor(form.getKor());

        return repo.save(j);
    }

    // DELETE by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
