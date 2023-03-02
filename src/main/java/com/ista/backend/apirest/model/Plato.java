package com.ista.backend.apirest.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "plato")
public class Plato {
	 @Id
	    private Long platoId;
	private String nombrePlato;
	private String descirpcion;
	private double precio;
	public String getNombrePlato() {
		return nombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}
	public String getDescirpcion() {
		return descirpcion;
	}
	public void setDescirpcion(String descirpcion) {
		this.descirpcion = descirpcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Long getPlatoId() {
		return platoId;
	}
	public void setPlatoId(Long platoId) {
		this.platoId = platoId;
	}
	
	
}
