package com.example.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
	
	Optional<Agency> findByLoginAndPassword(String login, String password);

}
