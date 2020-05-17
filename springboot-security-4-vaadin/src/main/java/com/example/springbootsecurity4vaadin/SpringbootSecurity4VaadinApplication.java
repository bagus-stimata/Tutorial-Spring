package com.example.springbootsecurity4vaadin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
// @SpringBootApplication(exclude = SecurityAutoConfiguration.class)
// @SpringBootApplication(scanBasePackageClasses = { SecurityConfig.class, SpringbootSecurity4VaadinApplication.class, SpringBootController.class
// 	 }, exclude = ErrorMvcAutoConfiguration.class)
public class SpringbootSecurity4VaadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurity4VaadinApplication.class, args);
	}

}
