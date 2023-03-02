package com.ista.backend.apirest.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.backend.apirest.model.Carta;
import com.ista.backend.apirest.model.Plato;
import com.ista.backend.apirest.repository.CartaRepository;
import com.ista.backend.apirest.repository.PlatoRepository;
@Service
public  class PlatoServiceImpl extends GenericServiceImpl<Plato, Long> implements PlatoService{

	  @Autowired
	  PlatoRepository platoRepository;
	
	@Override
	public CrudRepository<Plato, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

} 
