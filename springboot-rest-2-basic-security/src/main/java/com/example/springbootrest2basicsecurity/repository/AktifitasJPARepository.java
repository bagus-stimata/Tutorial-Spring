package com.example.springbootrest2basicsecurity.repository;




import com.example.springbootrest2basicsecurity.model.Aktifitas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AktifitasJPARepository extends JpaRepository<Aktifitas, Integer>{
    /*
    OTOMATIS TERDAPAT STANDART CRUD STANDART
    */


}