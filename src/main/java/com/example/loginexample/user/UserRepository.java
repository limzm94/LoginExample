package com.example.loginexample.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository to conduct CRUD operations with h2 db
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}