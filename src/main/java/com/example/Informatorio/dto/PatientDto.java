package com.example.Informatorio.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientDto {

	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(min = 4,  max= 20, message = "El nombre debe ser menor a 4 caracteres y mayor a 20.")
	private String name;
	
	
	@NotBlank(message = "El campo apellido no puede estar vacio")
	@Size(min = 4, max = 20, message = "El apellido debe ser menor a 4 caracteres y mayor a 20.")
	private String lastname;
	
	@NotNull(message="El campo dni no puede ser nulo")
	private Integer dni;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthdate;
	
	private String medicaAssurance;

	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PatientDto(String name, String lastname, Integer dni, Date birthdate, String medicaAssurance) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.birthdate = birthdate;
		this.medicaAssurance = medicaAssurance;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getMedicaAssurance() {
		return medicaAssurance;
	}


	public void setMedicaAssurance(String medicaAssurance) {
		this.medicaAssurance = medicaAssurance;
	}	
	

}
