package com.ista.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.backend.apirest.model.Cliente;
import com.ista.backend.apirest.model.Plato;
import com.ista.backend.apirest.service.ClienteService;
import com.ista.backend.apirest.service.PlatoService;

@RestController
@RequestMapping("/api/cliente")
public class ControllerCliente {
	@Autowired
	ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarRestaurante() {
        return new ResponseEntity<>(clienteService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearP(
            @RequestBody Cliente p) {
        return new ResponseEntity<>(clienteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarP(@PathVariable Long id, @RequestBody Cliente p) {
    	Cliente rest = clienteService.findById(id);
        if (rest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	rest.setNombre(p.getNombre());
            	rest.setApellido(p.getApellido());
            	rest.setCedula(p.getCedula());
            	rest.setCorreo(p.getCorreo());
            	
            
            	
                
                return new ResponseEntity<>(clienteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarP(@PathVariable Long id) {
    	clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
