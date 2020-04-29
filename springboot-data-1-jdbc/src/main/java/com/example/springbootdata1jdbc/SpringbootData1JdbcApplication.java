package com.example.springbootdata1jdbc;

import com.example.springbootdata1jdbc.jdbc_repositories.JdbcPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootData1JdbcApplication {

	//@Autowired
	JdbcPersonRepository jdbcPersonRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData1JdbcApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			Person person1 = new Person();
			person1.setName("bagus");
			person1.setAddress("Bagus Winarno");
	
			// jdbcPersonRepository.save(person1);
		
			// System.out.println("Let's inspect the beans provided by Spring Boot:");
			// String[] beanNames = ctx.getBeanDefinitionNames();
			// Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// 	System.out.println(beanName);
			// }


		};
		
	}

}
