package com.ista.backend.apirest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.ista.backend.apirest.model.Cliente;

import com.ista.backend.apirest.repository.ClienteRepository;


public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService{

	  @Autowired
	  ClienteRepository clienteRepository;
	
	@Override
	public CrudRepository<Cliente, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}
 
} 
