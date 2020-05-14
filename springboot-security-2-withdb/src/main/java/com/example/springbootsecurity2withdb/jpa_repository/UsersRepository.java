package com.example.springbootsecurity2withdb.jpa_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.springbootsecurity2withdb.model.FUser;

public interface UsersRepository extends JpaRepository<FUser, Integer> {
    Optional<FUser> findByEmail(String email);
    // Optional<FUser> findByUserName(String userName);
    Optional<FUser> findByUsername(String username);
}
