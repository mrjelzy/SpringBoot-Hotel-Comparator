package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Agency;

public interface AgencyRepository extends JpaRepository<Agency,Long> {

}
