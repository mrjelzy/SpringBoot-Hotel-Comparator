package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
