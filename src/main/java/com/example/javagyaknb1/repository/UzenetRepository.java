package com.example.javagyaknb1.repository;

import com.example.javagyaknb1.model.User;
import com.example.javagyaknb1.model.Uzenet;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UzenetRepository extends CrudRepository<Uzenet, Integer> {
    List<Uzenet> findByUserOrderByLetrehozasDesc(User user);  // saját üzenetek
    List<Uzenet> findAllByOrderByLetrehozasDesc();
}
