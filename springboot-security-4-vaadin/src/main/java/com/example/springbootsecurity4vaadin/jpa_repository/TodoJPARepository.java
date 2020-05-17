package com.example.springbootsecurity4vaadin.jpa_repository;

import com.example.springbootsecurity4vaadin.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoJPARepository extends JpaRepository<Todo, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}