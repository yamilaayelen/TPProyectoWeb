package com.javarevolutions.jsps.servlets.vo;

import java.io.Serializable;

public class VOLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7775167431914195386L;

	private String usuario;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String password;
	private String nombre;
	private Integer edad;
	
}
