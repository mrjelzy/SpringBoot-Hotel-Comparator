package com.example.rest.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.models.Agency;
import com.example.rest.models.Hotel;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.OfferRepository;

@Configuration
public class AgencyData {

	/* Attributes */
	private Logger logger = LoggerFactory.getLogger(AgencyData.class);

	@Bean
	public CommandLineRunner InitDatabase(AgencyRepository aRepository, HotelRepository hRepository,
			OfferRepository oRepository) {

		Agency agence = new Agency("Tour Tour", "tour", "tour", 0.3);
		aRepository.save(agence);

		Hotel h1 = new Hotel(1,"Le Ritz", "blanana", "Paris", "France", 5, "http://localhost:8080/hotelservice");
		/*
		 * Hotel h2 = new Hotel(2,"Le Negresco", "Promenade des anglais", "Nice",
		 * "France", 5);
		 */
		hRepository.save(h1);
		/* hRepository.save(h2); */


		return args -> {
			logger.info("Preloading database");
		};
	}
}
