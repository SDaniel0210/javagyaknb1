package com.example.javagyaknb1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "poszt")
public class Poszt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nev")
    private String nev;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }
}
