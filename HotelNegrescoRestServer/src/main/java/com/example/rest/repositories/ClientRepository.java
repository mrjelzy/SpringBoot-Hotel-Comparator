package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>  {

}
