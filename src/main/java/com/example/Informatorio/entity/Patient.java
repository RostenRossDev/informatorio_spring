package com.example.Informatorio.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="patients")
public class Patient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length =30)
	private String name;
	
	@Column(length =30)
	private String lastname; 
	private Integer dni;
	
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss")
	private Date birthdate;
	//private Address address;
	
	@Column(name="mecial_visit")
	private MedicalVisit medicalVisits;
	
	//@Column(name="medical_record")
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private MedicalRecord medicalRecord;
	
	@Column(name="medica_assurance")
	private String medicaAssurance;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public MedicalVisit getMedicalVisits() {
		return medicalVisits;
	}
	public void setMedicalVisits(MedicalVisit medicalVisits) {
		this.medicalVisits = medicalVisits;
	}
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public String getMedicaAssurance() {
		return medicaAssurance;
	}
	public void setMedicaAssurance(String medicaAssurance) {
		this.medicaAssurance = medicaAssurance;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Long id, String name, String lastname, Integer dni, Date birthdate, /*Address address,*/
			MedicalVisit medicalVisits, MedicalRecord medicalRecord, String medicaAssurance) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.birthdate = birthdate;
		//this.address = address;
		this.medicalVisits = medicalVisits;
		this.medicalRecord = medicalRecord;
		this.medicaAssurance = medicaAssurance;
	}
	
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", lastname=" + lastname + ", dni=" + dni + ", birthdate="
				+ birthdate + ", medicalVisits=" + medicalVisits + ", medicalRecord=" + medicalRecord
				+ ", medicaAssurance=" + medicaAssurance + "]";
	}
	
}
