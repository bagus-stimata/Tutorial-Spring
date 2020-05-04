package com.example.springbootdata4jpareadwrite;

import com.example.springbootdata4jpareadwrite.repo_read.BarRepository_Read;
import com.example.springbootdata4jpareadwrite.repo_write.BarRepository_Write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootData4JpaReadWriteApplication implements CommandLineRunner{

	@Autowired
	BarRepository_Read barRepository_Read;
	
	@Autowired
	BarRepository_Write barRepository_Write;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData4JpaReadWriteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		barRepository_Read.findAll();

	}

}
