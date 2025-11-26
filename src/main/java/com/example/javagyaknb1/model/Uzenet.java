package com.example.javagyaknb1.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="uzenetek")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "cim")
    private String cim;

    @Column(name = "uzenet")
    private String uzenet;

    @Column(name = "letrehozas")
    private LocalDateTime letrehozas;

    @PrePersist
    public void onCreate() {
        this.letrehozas = LocalDateTime.now();
    }

    // getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }

    public LocalDateTime getLetrehozas() {
        return letrehozas;
    }

    public void setLetrehozas(LocalDateTime letrehozas) {
        this.letrehozas = letrehozas;
    }
}
