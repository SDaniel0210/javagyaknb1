package com.example.javagyaknb1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "labdarugo")
public class Labdarugo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer mezszam;

    private String utonev;
    private String vezeteknev;

    private Integer magyar;
    private Integer kulfoldi;

    private Integer ertek;   // „ezer €”-ben

    private LocalDate szulido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klubid")
    private Klub klub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posztid")
    private Poszt poszt;

    // ---- GETTER / SETTER ----

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getMezszam() { return mezszam; }
    public void setMezszam(Integer mezszam) { this.mezszam = mezszam; }

    public String getUtonev() { return utonev; }
    public void setUtonev(String utonev) { this.utonev = utonev; }

    public String getVezeteknev() { return vezeteknev; }
    public void setVezeteknev(String vezeteknev) { this.vezeteknev = vezeteknev; }

    public Integer getMagyar() { return magyar; }
    public void setMagyar(Integer magyar) { this.magyar = magyar; }

    public Integer getKulfoldi() { return kulfoldi; }
    public void setKulfoldi(Integer kulfoldi) { this.kulfoldi = kulfoldi; }

    public Integer getErtek() { return ertek; }
    public void setErtek(Integer ertek) { this.ertek = ertek; }

    public LocalDate getSzulido() { return szulido; }
    public void setSzulido(LocalDate szulido) { this.szulido = szulido; }

    public Klub getKlub() { return klub; }
    public void setKlub(Klub klub) { this.klub = klub; }

    public Poszt getPoszt() { return poszt; }
    public void setPoszt(Poszt poszt) { this.poszt = poszt; }

    // Kényelmi metódus a \"Légiós\" oszlophoz
    @Transient
    public String getLegiosSzoveg() {
        if (magyar != null && (magyar == -1)) {
            return "Nem";
        } else if (kulfoldi != null && (kulfoldi == -1)) {
            return "Igen";
        } else {
            return "Ismeretlen";
        }
    }
}
