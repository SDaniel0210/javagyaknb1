package com.example.javagyaknb1.repository;

import com.example.javagyaknb1.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
