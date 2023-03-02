package com.ista.backend.apirest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cliente")
public class Cliente {
	 @Id
	    private Long clienId;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getClienId() {
		return clienId;
	}
	public void setClienId(Long clienId) {
		this.clienId = clienId;
	}
	
	
	
}
