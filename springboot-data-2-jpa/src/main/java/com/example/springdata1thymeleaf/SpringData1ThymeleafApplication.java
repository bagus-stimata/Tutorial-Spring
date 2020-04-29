package com.example.springdata1thymeleaf;

import java.time.LocalDate;

import com.example.springdata1thymeleaf.jpa_repository.TodoCrudRepository;
import com.example.springdata1thymeleaf.jpa_repository.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringData2JpaApplication {

	@Autowired
    private UserCrudRepository userCrudRepository;
	@Autowired
    private TodoCrudRepository todoCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringData2JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			// System.out.println("Let's inspect the beans provided by Spring Boot:");
			// String[] beanNames = ctx.getBeanDefinitionNames();
			// Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// 	System.out.println(beanName);
			// }

			Person person1 = new Person();
			person1.setName("bagus");
			person1.setAddress("Bagus Winarno");
	
			userCrudRepository.save(person1);

			
			Todo todo1 = new Todo();
			todo1.setDateFrom(LocalDate.now());
			todo1.setDateTo(LocalDate.now());
			todo1.setDescription("Manyapu");
			todo1.setPersonBean(person1);

			todoCrudRepository.save(todo1);

			Todo todo2 = new Todo();
			todo2.setDateFrom(LocalDate.now());
			todo2.setDateTo(LocalDate.now());
			todo2.setDescription("Mencuci");
			todo2.setPersonBean(person1);

			todoCrudRepository.save(todo2);


		};
		
	}
}
