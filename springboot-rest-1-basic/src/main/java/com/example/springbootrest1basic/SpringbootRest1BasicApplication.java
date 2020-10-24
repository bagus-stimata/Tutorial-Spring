package com.example.springbootrest1basic;

import com.example.springbootrest1basic.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringbootRest1BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRest1BasicApplication.class, args);
	}

}
