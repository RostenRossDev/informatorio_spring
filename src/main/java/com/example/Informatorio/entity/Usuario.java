package com.example.Informatorio.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//columnas de la tabla 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre_persona")
	private String nombrePersona;
	
	@Column(name="apellido_persona")
	private String apellido;
	
	@Column(name="fecha_nacimiento")
	private Date nacimiento;
	
	@Column(name="dni_persona")
	private Integer dni;
	
	@Column(name="email_persona")
	private String email;
	
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre, String apellido, Date nacimiento, Integer dni, String email) {
		super();
		this.nombrePersona = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.dni = dni;
		this.email = email;
	}

	public String getNombre() {
		return nombrePersona;
	}
	public void setNombre(String nombre) {
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
