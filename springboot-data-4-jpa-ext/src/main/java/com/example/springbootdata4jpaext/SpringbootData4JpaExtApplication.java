package com.example.springbootdata4jpaext;

import com.example.springbootdata4jpaext.model.Person;
import com.example.springbootdata4jpaext.repo_default.PersonJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootData4JpaExtApplication implements CommandLineRunner {
	
	@Autowired
    private PersonJPARepository personJPARepository;
	// @Autowired
    // private PersonJPARepository_Second personJPARepository_Second;
	/*
	Menggunakan CommandLineRunnerBisa
	*/
	@Override
	public void run(String... args) throws Exception {
		Person person1 = new Person();
		person1.setName("Bagus Winarno");
		person1.setAddress("Wangkal Kunjang");
		
		personJPARepository.save(person1);
		// personJPARepository_Second.save(person1);

		System.out.println("######## Size: " + personJPARepository.findAll().size());
		// System.out.println("######## Size: " + personJPARepository_Second.findAll().size());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData4JpaExtApplication.class, args);
	}

}
