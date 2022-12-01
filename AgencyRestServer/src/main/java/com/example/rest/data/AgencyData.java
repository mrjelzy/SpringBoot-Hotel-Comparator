package com.example.rest.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.models.Agency;
import com.example.rest.repositories.AgencyRepository;

@Configuration
public class AgencyData {
	
	private Logger logger = LoggerFactory.getLogger(AgencyData.class);

	@Bean
	public CommandLineRunner InitDatabase(AgencyRepository repository) {
		return args -> {
			logger.info("Preloading database with "
					+ repository.save(new Agency("TravelForLife", "travel", "travel", 0.10)));
			logger.info("Preloading database with "
					+ repository.save(new Agency("SmartTravel", "smart", "smart",0.3)));
		};
	}
}
