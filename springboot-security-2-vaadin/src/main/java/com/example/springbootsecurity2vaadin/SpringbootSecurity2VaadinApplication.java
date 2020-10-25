package com.example.springbootsecurity2vaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication(scanBasePackageClasses = { SecurityConfiguration.class, MainLayout.class, SpringbootSecurity2VaadinApplication.class }, exclude = ErrorMvcAutoConfiguration.class)
// @EnableJpaRepositories(basePackageClasses = { UsersRepository.class, CompanyRepository.class })
// @EntityScan(basePackageClasses = { FUser.class, Company.class })
public class SpringbootSecurity2VaadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurity2VaadinApplication.class, args);
	}

}
