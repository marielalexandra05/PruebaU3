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

import com.ista.backend.apirest.model.Carta;
import com.ista.backend.apirest.model.Cliente;
import com.ista.backend.apirest.service.CartaService;
import com.ista.backend.apirest.service.ClienteService;

@RestController
@RequestMapping("/api/carta")
public class ControllerCarta {
	@Autowired
	CartaService cartaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Carta>> listarRestaurante() {
        return new ResponseEntity<>(cartaService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Carta> crearP(
            @RequestBody Carta p) {
        return new ResponseEntity<>(cartaService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Carta> actualizarP(@PathVariable Long id, @RequestBody Carta p) {
    	Carta rest = cartaService.findById(id);
        if (rest == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	rest.setNombre(p.getNombre());
            	rest.setCategoria(p.getCategoria());
            	rest.setCantidad(p.getCantidad());
            	
                
                return new ResponseEntity<>(cartaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Carta> eliminarP(@PathVariable Long id) {
    	cartaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
