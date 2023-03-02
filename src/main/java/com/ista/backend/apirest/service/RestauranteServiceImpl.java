package com.ista.backend.apirest.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.backend.apirest.model.Restaurante;
import com.ista.backend.apirest.repository.RestaurantRepository;


@Service
public class RestauranteServiceImpl extends GenericServiceImpl<Restaurante, Long> implements RestauranteService{

	  @Autowired
	    RestaurantRepository restauranteRepository;
	
	@Override
	public CrudRepository<Restaurante, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}
   
}
