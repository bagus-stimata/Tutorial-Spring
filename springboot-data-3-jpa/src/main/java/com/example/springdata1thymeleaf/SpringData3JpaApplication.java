package com.example.springdata1thymeleaf;

import java.time.LocalDate;

import com.example.springdata1thymeleaf.jpa_repository.PersonJPARepository;
import com.example.springdata1thymeleaf.jpa_repository.TodoJPARepository;
import com.example.springdata1thymeleaf.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringData3JpaApplication implements CommandLineRunner{

	@Autowired
    private TodoJPARepository todoCrudRepository;
	@Autowired
    private PersonJPARepository personJPARepository;

	/*
	Menggunakan CommandLineRunnerBisa
	*/
	@Override
	public void run(String... args) throws Exception {
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringData3JpaApplication.class, args);
	}

	
}
