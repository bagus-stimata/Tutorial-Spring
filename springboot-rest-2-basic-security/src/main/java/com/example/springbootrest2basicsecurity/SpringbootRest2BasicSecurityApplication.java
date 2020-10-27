package com.example.springbootrest2basicsecurity;

import com.example.springbootrest2basicsecurity.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringbootRest2BasicSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRest2BasicSecurityApplication.class, args);
	}

}
