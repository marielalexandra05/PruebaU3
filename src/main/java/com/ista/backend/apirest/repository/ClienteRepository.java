package com.ista.backend.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.backend.apirest.model.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente,Long>{

}
