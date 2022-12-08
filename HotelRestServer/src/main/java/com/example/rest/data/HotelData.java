package com.example.rest.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.models.Agency;
import com.example.rest.models.Booking;
import com.example.rest.models.Client;
import com.example.rest.models.Hotel;
import com.example.rest.models.Partnership;
import com.example.rest.models.Room;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.BookingRepository;
import com.example.rest.repositories.ClientRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.PartnershipRepository;
import com.example.rest.repositories.RoomRepository;

@Configuration
public class HotelData {

	private Logger logger = LoggerFactory.getLogger(HotelData.class);

	@Bean
	public CommandLineRunner InitDatabase(HotelRepository hRepository, AgencyRepository aRepository,
			PartnershipRepository pRepository, BookingRepository bRepository, ClientRepository cRepository,
			RoomRepository rRepository) {
		Hotel h1 = new Hotel("Le Ritz", "blanana", "Paris", "France", 5);
		hRepository.save(h1);
		
		Agency a1 = new Agency("Tour", "tour", "tour");
		Agency a2 = new Agency("Tim Cook", "tim", "cook");
		aRepository.save(a1);
		aRepository.save(a2);
		
		Partnership p1 = new Partnership(h1, a1, 0.1);
		Partnership p2 = new Partnership(h1, a2, 0.5);
		
		pRepository.save(p1);
		pRepository.save(p2);
		
		Client c1 = new Client("Ryan", "Bengoufa", "345678", "45");
		Client c2 = new Client("Lucas", "Manolo", "345678", "45");
		cRepository.save(c1);
		cRepository.save(c2);
		
		Room r1 = new Room(3, 3000);
		Room r2 = new Room(5, 9000);
		Room r3 = new Room(6, 10000);
		Room r4 = new Room(8, 8000);
		rRepository.save(r1);
		rRepository.save(r2);
		rRepository.save(r3);
		rRepository.save(r4);
		
		LocalDate start = LocalDate.of(2022, 12, 15);
		LocalDate end = LocalDate.of(2022, 12, 20);
		
		Booking b1 = new Booking(c1 ,a1, r3, start, end);
		Booking b2 = new Booking(c2 ,a1, r4, start, end);
		bRepository.save(b1);
		bRepository.save(b2);
		return args -> {
			logger.info("Preloading database");
		};
	}
}
