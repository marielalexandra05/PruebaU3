package com.ista.backend.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.backend.apirest.model.Carta;


public interface CartaRepository extends MongoRepository<Carta,Long>{

}
