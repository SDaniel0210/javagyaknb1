package com.example.javagyaknb1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/**","/login","/bejelentkezes","/regisztracio","/resources/**", "/stylesheets/**", "/images/**", "/javascripts/**").permitAll()
                                .requestMatchers("/uzenetek").authenticated()
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                ).formLogin(
                        form -> form
                                .loginPage("/bejelentkezes")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/", true)
                                .failureUrl("/bejelentkezes?error")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutSuccessUrl("/")
                                .permitAll()
                );
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }
}