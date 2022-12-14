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
import com.example.rest.models.Room;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.BookingRepository;
import com.example.rest.repositories.ClientRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.RoomRepository;

@Configuration
public class HotelData {

	private Logger logger = LoggerFactory.getLogger(HotelData.class);

	@Bean
	public CommandLineRunner InitDatabase(HotelRepository hRepository, AgencyRepository aRepository, BookingRepository bRepository, ClientRepository cRepository,
			RoomRepository rRepository) {
		Hotel h1 = new Hotel("Sheraton", "Via Caldera, 3", "Milan", "Italie", 3);
		hRepository.save(h1);
		
		Agency a1 = new Agency("Smart Travel", "smart", "smart", 0.17);
		aRepository.save(a1);
		
		
		Client c1 = new Client("Ryan", "Bengoufa", "345678","12/23" ,"45");
		Client c2 = new Client("Lucas", "Manolo", "345678","12/25" ,"45");
		cRepository.save(c1);
		cRepository.save(c2);
		
		Room r1 = new Room(1, 128.25, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/409940770.jpg?k=76b6a62e229eea3cd9ed279e1f23a6cd8d7a6e76849fd59b5eef406a95706f78&o=&hp=1");
		Room r2 = new Room(2, 115.69, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/206967994.jpg?k=e90201be923b9965459323e977530f066fcaed85f7f89e9d1f7f8b66a2b756a4&o=&hp=1");
		Room r3 = new Room(5, 125.45, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/366419089.jpg?k=39a1c650c952795135ac0866cb97ed3096e08837e6e576682a2874bc3a45f201&o=&hp=1");
		Room r4 = new Room(3, 259.36, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/156333415.jpg?k=77dcf931d3673448a39e9ce378f57c4d056f1639645759bc46661c038271f63e&o=&hp=1");
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
