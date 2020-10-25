package com.example.springbootsecurity1vaadin.security_repository;

import com.example.springbootsecurity1vaadin.security_model.FUser;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsersJPARepository extends JpaRepository<FUser, Integer> {
    FUser findByEmail(String email);
    // Optional<FUser> findByUserName(String userName);
    FUser findByUsername(String username);
}
