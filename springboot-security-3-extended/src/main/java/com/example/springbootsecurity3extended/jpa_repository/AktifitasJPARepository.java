package com.example.springbootsecurity3extended.jpa_repository;

import com.example.springbootsecurity3extended.model.Aktifitas;


import org.springframework.data.jpa.repository.JpaRepository;


public interface AktifitasJPARepository extends JpaRepository<Aktifitas, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}