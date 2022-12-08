package com.example.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages={
		"com.example.rest.models"
		
}) 
@EnableJpaRepositories(basePackages={
		"com.example.rest.repositories"
})

@SpringBootApplication(scanBasePackages= {
		"com.example.rest.controllers",
		"come.example.rest.exception"
})
public class AgencyRestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgencyRestServerApplication.class, args);
	}

}
