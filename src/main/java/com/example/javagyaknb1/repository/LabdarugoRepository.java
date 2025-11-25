package com.example.javagyaknb1.repository;

import com.example.javagyaknb1.model.Labdarugo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabdarugoRepository extends JpaRepository<Labdarugo, Integer> {

    @Query("""
           SELECT l FROM Labdarugo l
           LEFT JOIN FETCH l.klub k
           LEFT JOIN FETCH l.poszt p
           ORDER BY k.csapatnev, l.vezeteknev, l.utonev
           """)
    List<Labdarugo> findAllWithKlubAndPosztSorted();
}
