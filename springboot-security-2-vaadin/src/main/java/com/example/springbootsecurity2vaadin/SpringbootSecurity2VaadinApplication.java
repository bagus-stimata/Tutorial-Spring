package com.example.springbootsecurity2vaadin;

import com.example.springbootsecurity2vaadin.SecurityConfig.SecurityConfiguration;
import com.example.springbootsecurity2vaadin.jpa_repository.UsersRepository;
import com.example.springbootsecurity2vaadin.model.FUser;
import com.example.springbootsecurity2vaadin.ui.MainLayout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @SpringBootApplication(scanBasePackageClasses = { SecurityConfiguration.class, MainLayout.class, SpringbootSecurity2VaadinApplication.class }, exclude = ErrorMvcAutoConfiguration.class)
// @EnableJpaRepositories(basePackageClasses = { UsersRepository.class, CompanyRepository.class })
// @EntityScan(basePackageClasses = { FUser.class, Company.class })
public class SpringbootSecurity2VaadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurity2VaadinApplication.class, args);
	}

}
