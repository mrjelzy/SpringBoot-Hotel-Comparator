package com.example.rest.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.models.Hotel;
import com.example.rest.repositories.HotelRepository;

@Configuration
public class HotelData {

	private Logger logger = LoggerFactory.getLogger(HotelData.class);

	@Bean
	public CommandLineRunner InitDatabase(HotelRepository repository) {
		return args -> {
			logger.info("Preloading database with "
					+ repository.save(new Hotel("Le Ritz", "blanana", "Paris", "France", 5)));
			logger.info("Preloading database with "
					+ repository.save(new Hotel("Le Negresco", "blanana", "Nice", "France", 5)));
		};
	}
}
