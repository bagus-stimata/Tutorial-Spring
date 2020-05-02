package com.example.springdata1thymeleaf.jpa_repository;


import com.example.springdata1thymeleaf.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoJPARepository extends JpaRepository<Todo, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}