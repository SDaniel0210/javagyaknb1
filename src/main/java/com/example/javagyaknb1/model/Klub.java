package com.example.javagyaknb1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "klub")
public class Klub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "csapatnev")
    private String csapatnev;

    // getter / setter

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCsapatnev() { return csapatnev; }
    public void setCsapatnev(String csapatnev) { this.csapatnev = csapatnev; }
}
