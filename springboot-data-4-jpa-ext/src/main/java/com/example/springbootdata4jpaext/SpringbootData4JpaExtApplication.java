package com.example.springbootdata4jpaext;

import com.example.springbootdata4jpaext.bar.repo.BarRepository;
import com.example.springbootdata4jpaext.foo.repo.FooRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringbootData4JpaExtApplication implements CommandLineRunner{

	@Autowired
	FooRepository fooRepository;
	@Autowired
	BarRepository barRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData4JpaExtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Oke boss ############# End");
		fooRepository.findAll();
		System.out.println("Foo Size: " +  fooRepository.findAll().size());
		System.out.println("Bar Size: " +  barRepository.findAll().size());
	
	}

}
