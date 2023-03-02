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

import com.ista.backend.apirest.model.Plato;
import com.ista.backend.apirest.model.Restaurante;
import com.ista.backend.apirest.service.PlatoService;
import com.ista.backend.apirest.service.RestauranteService;
@RestController
@RequestMapping("/api/plato")
public class ControllerPlato {
	@Autowired
    PlatoService platoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Plato>> listarRestaurante() {
        return new ResponseEntity<>(platoService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Plato> crearP(
            @RequestBody Plato p) {
        return new ResponseEntity<>(platoService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plato> actualizarP(@PathVariable Long id, @RequestBody Plato p) {
    	Plato rest = platoService.findById(id);
        if (rest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	rest.setNombrePlato(p.getNombrePlato());
            	rest.setDescirpcion(p.getDescirpcion());
            	rest.setPrecio(p.getPrecio());
            
            	
                
                return new ResponseEntity<>(platoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Plato> eliminarP(@PathVariable Long id) {
    	platoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
