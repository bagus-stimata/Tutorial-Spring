package com.example.springbootsecurity3extended.jpa_repository;

import com.example.springbootsecurity3extended.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoJPARepository extends JpaRepository<Todo, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}