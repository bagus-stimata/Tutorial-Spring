package com.example.springbootsecurity1vaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
// @SpringBootApplication(scanBasePackageClasses = { SecurityConfiguration.class, MainView.class, Application.class,  }, exclude = ErrorMvcAutoConfiguration.class)
// @EnableJpaRepositories(basePackageClasses = { UsersRepository.class })
// @EntityScan(basePackageClasses = { FUser.class })
public class SpringbootSecurity1VaadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurity1VaadinApplication.class, args);
	}

}
