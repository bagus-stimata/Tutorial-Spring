package com.example.springbootrest3security.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.springbootrest3security.model.FUser;



public interface UsersRepository extends JpaRepository<FUser, Integer> {
    Optional<FUser> findByEmail(String email);
    // Optional<FUser> findByUserName(String userName);
    Optional<FUser> findByUsername(String username);
}
