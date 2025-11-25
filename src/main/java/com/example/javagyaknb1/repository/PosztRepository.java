package com.example.javagyaknb1.repository;

import com.example.javagyaknb1.model.Poszt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosztRepository extends JpaRepository<Poszt, Integer> {

    @Query("""
            SELECT p.nev, COUNT(l.id)
            FROM Poszt p
            LEFT JOIN Labdarugo l ON l.poszt.id = p.id
            GROUP BY p.id, p.nev
            ORDER BY p.id
           """)
    List<Object[]> countPlayersByPoszt();
}
