package com.demo.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	// since this class is annotated with @SpringBootApplication it is already a java configuration class
	// so we can configure RestTemplate bean here
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
