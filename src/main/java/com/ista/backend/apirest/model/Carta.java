package com.ista.backend.apirest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "carta")
public class Carta {
	 @Id
	    private Long cartaId;
	private String nombre;
	private String categoria;
	private String cantidad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public Long getCartaId() {
		return cartaId;
	}
	public void setCartaId(Long cartaId) {
		this.cartaId = cartaId;
	}
	
	
}
