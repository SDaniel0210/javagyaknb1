package com.example.javagyaknb1.config;

import com.example.javagyaknb1.model.Uzenet;
import com.example.javagyaknb1.model.User;
import com.example.javagyaknb1.repository.UzenetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzenetService {

    @Autowired
    private UzenetRepository UzenetRepo;

    public void save(Uzenet uzenet) {
        UzenetRepo.save(uzenet);
    }

    public List<Uzenet> getUserUzenetek(User user) {
        return UzenetRepo.findByUserOrderByLetrehozasDesc(user);
    }

    public List<Uzenet> getAllUzenetek() {
        return UzenetRepo.findAllByOrderByLetrehozasDesc();
    }

    public void delete(int id) {
        UzenetRepo.deleteById(id);
    }
}