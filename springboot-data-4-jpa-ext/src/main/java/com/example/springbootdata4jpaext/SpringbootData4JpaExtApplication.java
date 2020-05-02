package com.example.springbootdata4jpaext;

import com.example.springbootdata4jpaext.repo_default.PersonJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootData4JpaExtApplication implements CommandLineRunner {
	
	@Autowired
    private PersonJPARepository personJPARepository;
	/*
	Menggunakan CommandLineRunnerBisa
	*/
	@Override
	public void run(String... args) throws Exception {
		System.out.println("######## Size: " + personJPARepository.findAll().size());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData4JpaExtApplication.class, args);
	}

}
