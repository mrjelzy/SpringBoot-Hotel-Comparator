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
		"com.example.rest.data",
		"com.example.rest.controllers",
		"come.example.rest.exceptions"
})
public class HotelRestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestServerApplication.class, args);
	}

}
