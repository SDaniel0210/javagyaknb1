package com.example.javagyaknb1.config;

import com.example.javagyaknb1.model.User;
import com.example.javagyaknb1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    public void register(User user) {

        // role
        if (user.getEmail().equals("admin@admin")) {
            user.setRole("ADMIN");
        } else {
            user.setRole("USER");
        }

        // elmentjük a nyers jelszót
        String rawPassword = user.getPassword();

        // hash
        user.setPassword(encoder.encode(rawPassword));

        // 1. ELŐBB MENTSÜK EL AZ ADATBÁZISBA
        userRepo.save(user);
    }

    public void autoLogin(String email, String rawPassword) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, rawPassword);
        Authentication auth = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}