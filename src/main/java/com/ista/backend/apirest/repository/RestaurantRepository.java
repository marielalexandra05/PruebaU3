package com.ista.backend.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.backend.apirest.model.Restaurante;

public interface RestaurantRepository extends MongoRepository<Restaurante,Long>{

}
