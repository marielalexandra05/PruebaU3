package com.ista.backend.apirest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.backend.apirest.model.Carta;

import com.ista.backend.apirest.repository.CartaRepository;

@Service
public  class CaratServiceImpl extends GenericServiceImpl<Carta, Long> implements CartaService{

	  @Autowired
	  CartaRepository cartaRepository;
	
	@Override
	public CrudRepository<Carta, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

} 

