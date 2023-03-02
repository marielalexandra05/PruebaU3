package com.ista.backend.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.backend.apirest.model.Plato;

public interface PlatoRepository extends MongoRepository<Plato,Long>{

}
