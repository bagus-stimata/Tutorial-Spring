package com.example.springbootsecurity2vaadin.jpa_repository;

import com.example.springbootsecurity2vaadin.model.FUser;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsersRepository extends JpaRepository<FUser, Integer> {
    FUser findByEmail(String email);
    // Optional<FUser> findByUserName(String userName);
    FUser findByUsername(String username);
}
