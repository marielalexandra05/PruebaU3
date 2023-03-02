package com.ista.backend.apirest.controllers;

import java.io.Serializable;
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

import com.ista.backend.apirest.model.Restaurante;
import com.ista.backend.apirest.service.RestauranteService;



@RestController
@RequestMapping("/api/restaurante")
public class ControllerRestaurante {
	@Autowired
    RestauranteService restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestaurante() {
        return new ResponseEntity<>(restauranteService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearRestaurante(
            @RequestBody Restaurante p) {
        return new ResponseEntity<>(restauranteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante p) {
    	Restaurante rest = restauranteService.findById(id);
        if (rest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	rest.setNombre(p.getNombre());
            	rest.setTelefono(p.getTelefono());
            	rest.setCorreo(p.getCorreo());
            	rest.setDireccion(p.getDireccion());
            	
                
                return new ResponseEntity<>(restauranteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarRestaurante(@PathVariable Long id) {
    	restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
