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

import com.example.rest.exceptions.AgencyNotFoundException;
import com.example.rest.models.Agency;
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
	public Agency getEmployeeById(@PathVariable long id) throws AgencyNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new AgencyNotFoundException("Error : Could not fint employee with id : " + id));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/agencies")
	public Agency createAgency(@RequestBody Agency agency) {
		return repository.save(agency);
	}

	@PutMapping(uri + "/agencies/{id}")
	public Agency updateEmployee(@RequestBody Agency newAgency, @PathVariable long id) {
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
	public void deleteEmployee(@PathVariable long id) throws AgencyNotFoundException {
		Agency agency = repository.findById(id)
				.orElseThrow(() -> new AgencyNotFoundException("Error : Could not fint employee with id : " + id));
		repository.delete(agency);
	}

}
