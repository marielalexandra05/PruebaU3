package com.ista.backend.apirest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "restaurante")
public class Restaurante {
	 @Id
	    private Long restId;
	 
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getRestId() {
		return restId;
	}
	public void setRestId(Long restId) {
		this.restId = restId;
	}
	
	
	
}
