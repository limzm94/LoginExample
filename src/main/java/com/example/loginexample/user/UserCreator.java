package com.example.loginexample.user;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class UserCreator {

    @Autowired
    private UserRepository userRepository;

    // create 1 user and 1 manager account and insert into h2 database
    @PostConstruct
    public void init() {
        userRepository.save(new User("Casper Mckee", "user1","user1@email.com",  new BCryptPasswordEncoder().encode("password1"), "User"));
        userRepository.save(new User("Dawson Fuentes", "manager2","manager2@email.com",  new BCryptPasswordEncoder().encode("password2"), "Manager"));
        // etc
    }
}