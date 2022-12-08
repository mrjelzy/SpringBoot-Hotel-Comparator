package com.example.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.rest.exceptions.AgencyNotFoundException;
import com.example.rest.models.Agency;
import com.example.rest.models.Offer;
import com.example.rest.models.Search;
import com.example.rest.repositories.AgencyRepository;

@RestController
public class AgencyController {

	/* ATTRIBUTES */
	@Autowired
	private AgencyRepository repository;
	private static final String uri = "agencyservice/api";

	/* METHODS */
	@GetMapping(uri + "/agencies")
	public List<Agency> getAllAgencys() {
		return repository.findAll();
	}

	@GetMapping(uri + "/agencies/count")
	public String count() {
		return String.format("{\"%s\" : %s}", "count", repository.count());
	}

	@GetMapping(uri + "/agencies/{id}")
	public Agency getAgencyById(@PathVariable long id) throws AgencyNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new AgencyNotFoundException("Error : Could not fint employee with id : " + id));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/agencies")
	public Agency createAgency(@RequestBody Agency agency) {
		return repository.save(agency);
	}

	@PutMapping(uri + "/agencies/{id}")
	public Agency updateAgency(@RequestBody Agency newAgency, @PathVariable long id) {
		return repository.findById(id).map(agency -> {
			agency.setName(newAgency.getName());
			agency.setLogin(newAgency.getLogin());
			agency.setPassword(newAgency.getPassword());
			agency.setDiscount(newAgency.getDiscount());
			repository.save(agency);
			return agency;
		}).orElseGet(() -> {
			newAgency.setId(id);
			repository.save(newAgency);
			return newAgency;
		});
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri + "/agencies/{id}")
	public void deleteAgency(@PathVariable long id) throws AgencyNotFoundException {
		Agency agency = repository.findById(id)
				.orElseThrow(() -> new AgencyNotFoundException("Error : Could not fint employee with id : " + id));
		repository.delete(agency);
	}

	/*@PostMapping(uri + "/agencies/sendSearch")
	public Todo sendResearch(@RequestBody Todo t/*Search search) {
		//Todo t=new Todo(101,18L,"titre test", "lorem ipsum");
		System.out.println(t);
		RestTemplate restTemplate=new RestTemplate();
		Todo savedtodo=restTemplate.postForObject("https://jsonplaceholder.typicode.com/todos", t,Todo.class);
		System.out.println(savedtodo);
		return savedtodo;
	}*/
	
	@PostMapping(uri + "/agencies/sendSearch")
	public Search sendSearch(@RequestBody Search search) {
		//Todo t=new Todo(101,18L,"titre test", "lorem ipsum");
		RestTemplate restTemplate=new RestTemplate();
		Search savedSearch=restTemplate.postForObject("http://localhost:8080/hotel/api/",search,Search.class);
		System.out.println(savedSearch);
		return search;
	}
	
	@PostMapping(uri + "/agencies/receiveOffers")
	public List<Offer> receiveOffers(){
		
		RestTemplate restTemplate=new RestTemplate();
		List<Offer> savedOffers=restTemplate.getForObject("http://localhost:8080/hotel/api/", List.class);
		
		return null;
	}
	

}
