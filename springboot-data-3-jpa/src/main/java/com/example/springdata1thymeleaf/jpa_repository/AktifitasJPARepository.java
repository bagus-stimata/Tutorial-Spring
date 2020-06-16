package com.example.springdata1thymeleaf.jpa_repository;




import com.example.springdata1thymeleaf.model.Aktifitas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AktifitasJPARepository extends JpaRepository<Aktifitas, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}