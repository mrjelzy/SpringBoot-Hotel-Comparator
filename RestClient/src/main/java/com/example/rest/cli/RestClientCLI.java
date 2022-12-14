package com.example.rest.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.rest.models.Agency;
import com.example.rest.models.Booking;
import com.example.rest.models.InputBooking;
import com.example.rest.models.InputSearch;
import com.example.rest.models.Offer;

@Component
public class RestClientCLI extends AbstractMain implements CommandLineRunner {

	/* ATTRIBUTES */
	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private static String URI_AGENCIES;

	@Override
	public void run(String... args) throws Exception {

		BufferedReader inputReader;
		String userInput = "";

		try {

			inputReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choisissez ce que vous voulez faire : ");
			System.out.println("\n1. Se connecter à une agence");
			System.out.println("\n2. Utiliser le Compararteur");
			String choice = inputReader.readLine();
			System.out.println();

			if (choice.equals("1")) {
				setTestServiceUrl(inputReader);

				URI_AGENCIES = SERVICE_AGENCY_URL + "/api/agencies";

				do {
					menu();
					userInput = inputReader.readLine();
					processUserInput(inputReader, userInput, proxy);
					Thread.sleep(3000);
				} while (!userInput.equals(QUIT));
			}

			if (choice.equals("2")) {

				InputSearch search = userInputSearch(inputReader, "comparator");
				List<Offer> listOffer = new ArrayList<Offer>();
				List<String> agenciesName = List.of("tour");
				List<Integer> nbOffersByAgence = new ArrayList<Integer>();

				for (String a : agenciesName) {
					URI_AGENCIES = "http://localhost:8081/agencyservice/" + a + "/api";
					Offer[] offers = proxy.postForObject(URI_AGENCIES + "/agencies/sendSearch", search, Offer[].class);
					Agency agency = proxy.getForObject(URI_AGENCIES + "/agencies", Agency.class);
					nbOffersByAgence.add(offers.length);

					listOffer.addAll(Arrays.asList(offers));

					for (Offer o : listOffer)
						o.setAgency(agency);
				}

				System.out.println("Résultat de la recherche :");
				if (!listOffer.isEmpty()) {
					URI_AGENCIES = "http://localhost:8081/agencyservice/";
					offersMenu(listOffer);
					int userChoice = Integer.parseInt(inputReader.readLine());
					System.out.println();

					Offer choosenOffer = listOffer.get(userChoice - 1);

					InputBooking inputBooking = userInputBooking(inputReader, choosenOffer);

					for (int j = 0; j < agenciesName.size(); j++) {
						if (userChoice <= nbOffersByAgence.get(j)) {
							URI_AGENCIES += agenciesName.get(j) + "/api/agencies/sendChoice";
						}
					}

					Booking booking = proxy.postForObject(URI_AGENCIES, inputBooking, Booking.class);

					System.out.println("Réservation confirmée : " + booking.toString());
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected boolean validServiceUrl() {
		return SERVICE_AGENCY_URL.equals("http://localhost:8081/agencyservice");
	}

	@Override
	protected void menu() {

		StringBuilder builder = new StringBuilder();
		builder.append(QUIT + ". Quit.");
		builder.append("\n1. Recherche.");
		builder.append("\n2. Voir tout les hotels.");
		System.out.println(builder);

	}

	protected void offersMenu(List<Offer> offers) {
		StringBuilder builder = new StringBuilder();
		int i = 1;
		for (Offer o : offers) {
			builder.append("\n" + i + o.toString());
			i++;
		}
		System.out.println(builder);
	}

	protected InputSearch userInputSearch(BufferedReader reader, String caller) {
		try {
			System.out.println("Veuillez entrer le pays de reservation :");
			String country = reader.readLine();
			System.out.println();

			System.out.println("Veuillez entrer la ville de reservation :");
			String city = reader.readLine();
			System.out.println();

			System.out.println("Veuillez entrer la date d'arrivée:");
			LocalDate start = LocalDate.parse(reader.readLine());
			System.out.println();

			System.out.println("Veuillez entrez la date de départ :");
			LocalDate end = LocalDate.parse(reader.readLine());
			System.out.println();

			double  maxPrice;
			if (caller.equals("agency")) {
				System.out.println("Veuillez entrez le prix maximum:");
				maxPrice = Double.parseDouble(reader.readLine());
				System.out.println();
			}
			
			else {
				maxPrice=0;
			}

			System.out.println("Veuillez entrez le nombre de personne :");
			int nbPeople = Integer.parseInt(reader.readLine());
			System.out.println();

			System.out.println("Veuillez entrez le nombre d'étoile souhaite:");
			int nbStars = Integer.parseInt(reader.readLine());
			System.out.println();

			return new InputSearch(city, country, start, end, nbPeople, nbStars, maxPrice);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected InputBooking userInputBooking(BufferedReader reader, Offer choosenOffer) {
		try {
			System.out.println("Indiquez votre nom: ");
			String name = reader.readLine();
			System.out.println();

			System.out.println("Indiquez votre prenom: ");
			String surname = reader.readLine();
			System.out.println();

			System.out.println("Indiquez votre numéro de carte bancaire: ");
			String card = reader.readLine();
			System.out.println();

			System.out.println("Indiquez le cvv de votre carte: ");
			String cvv = reader.readLine();
			System.out.println();

			System.out.println("Indiquez la date d'expiration de votre carte: ");
			String exp = reader.readLine();
			System.out.println();

			return new InputBooking(choosenOffer.getIdOffer(), name, surname, card, cvv, exp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {

		try {
			switch (userInput) {
			case "1":

				InputSearch search = userInputSearch(reader, "agency");

				double gaps = Math.abs(ChronoUnit.DAYS.between(search.getStart(), search.getEnd()));

				Offer[] offers = proxy.postForObject(URI_AGENCIES + "/sendSearch", search, Offer[].class);
				List<Offer> listOffer = new ArrayList<Offer>();

				for (Offer o : offers) {
					double totalPrice = o.getRoom().getPrice() * gaps * (1 - o.getDiscount());
					System.out.println(search.getMaxPrice() >= totalPrice);
					if (search.getMaxPrice() >= totalPrice) {
						listOffer.add(o);
					}
				}
				if (!listOffer.isEmpty()) {
					offersMenu(listOffer);
					String userChoice = reader.readLine();

					Offer choosenOffer = listOffer.get(Integer.parseInt(userChoice) - 1);

					InputBooking inputBooking = userInputBooking(reader, choosenOffer);

					Booking booking = proxy.postForObject(URI_AGENCIES + "/sendChoice", inputBooking, Booking.class);

					System.out.println("Réservation confirmée : " + booking.toString());
				}
				break;

			case QUIT:
				System.out.println("Bye Bye");
				return;
			default:
				System.err.println("Désolé mauvais input");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
