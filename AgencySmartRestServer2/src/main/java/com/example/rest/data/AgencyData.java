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

		Agency agence = new Agency("Smart Travel", "smart", "smart", 0.17);
		aRepository.save(agence);

		Hotel h1 = new Hotel(1, "Pullmlan", "1 Rue des Pertuisanes", "Montpellier", "France", 4,
				"http://localhost:8082/hotelservice/pullman");
		Hotel h2 = new Hotel(2, "Sheraton", "Via Caldera, 3", "Milan", "Italie", 3,
				"http://localhost:8086/hotelservice/sheraton");

		hRepository.save(h1);
		hRepository.save(h2);

		return args -> {
			logger.info("Preloading database");
		};
	}
}
