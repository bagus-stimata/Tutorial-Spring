package com.example.springbootdata4jpareadwrite;

import com.example.springbootdata4jpareadwrite.repo_read.BarRepository_Read;
import com.example.springbootdata4jpareadwrite.repo_write.BarRepository_Write;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootData4JpaReadWriteApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BarRepository_Read barRepository_Read;
	
	@Autowired
	BarRepository_Write barRepository_Write;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData4JpaReadWriteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("################################");
		System.out.println("JUMLAH Write: " + barRepository_Write.findAll().size() );
		System.out.println("JUMLAH Read: " + barRepository_Read.findAll().size() );

	}

}
