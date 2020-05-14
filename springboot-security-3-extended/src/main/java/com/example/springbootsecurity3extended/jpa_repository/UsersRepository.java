package com.example.springbootsecurity3extended.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.springbootsecurity3extended.model.FUser;


public interface UsersRepository extends JpaRepository<FUser, Integer> {
    // Optional<FUser> findByEmail(String email);
    FUser findByEmail(String email);

    // Optional<FUser> findByUsername(String username);
    FUser findByUsername(String username);


}
