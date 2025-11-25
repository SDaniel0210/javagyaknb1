package com.example.javagyaknb1.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crud_labdarugok")
public class CrudLabdarugo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nev;

    @Column(nullable = false)
    private Integer mezszam;

    @Column(nullable = false, length = 255)
    private String poszt;

    @Column(nullable = false, length = 255)
    private String csapat;

    @Column(nullable = false)
    private Integer ertek;

    @Column(nullable = false)
    private Integer kor;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ==== GETTEREK / SETTEREK ====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getMezszam() {
        return mezszam;
    }

    public void setMezszam(Integer mezszam) {
        this.mezszam = mezszam;
    }

    public String getPoszt() {
        return poszt;
    }

    public void setPoszt(String poszt) {
        this.poszt = poszt;
    }

    public String getCsapat() {
        return csapat;
    }

    public void setCsapat(String csapat) {
        this.csapat = csapat;
    }

    public Integer getErtek() {
        return ertek;
    }

    public void setErtek(Integer ertek) {
        this.ertek = ertek;
    }

    public Integer getKor() {
        return kor;
    }

    public void setKor(Integer kor) {
        this.kor = kor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
