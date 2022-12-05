package com.example.rest.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.models.Agency;
import com.example.rest.models.Hotel;
import com.example.rest.models.Partnership;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.PartnershipRepository;

@Configuration
public class HotelData {

	private Logger logger = LoggerFactory.getLogger(HotelData.class);

	@Bean
	public CommandLineRunner InitDatabase(HotelRepository hRepository, AgencyRepository aRepository,
			PartnershipRepository pRepository) {
		Hotel h1 = new Hotel("Le Ritz", "blanana", "Paris", "France", 5);
		Hotel h2 = new Hotel("Le Negresco", "blanana", "Nice", "France", 5);
		hRepository.save(h1);
		hRepository.save(h2);
		
		Agency a1 = new Agency("Tour", "tour", "tour");
		Agency a2 = new Agency("Tim Cook", "tim", "cook");
		aRepository.save(a1);
		aRepository.save(a2);
		
		Partnership p1 = new Partnership(h1, a1, 0.1);
		Partnership p2 = new Partnership(h2, a2, 0.5);
		
		pRepository.save(p1);
		pRepository.save(p2);
		
		return args -> {
			logger.info("Preloading database");
		};
	}
}
