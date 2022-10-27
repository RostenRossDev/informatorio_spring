package com.example.Informatorio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity(name="doctors")
public class Doctor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String lastname;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "doctors_id_specialities_id", 
        joinColumns = { @JoinColumn(name = "doctor_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "specialitie_id")} , 
        uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_id","specialitie_id"})}
    )
	private List<Specialty> specialty;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MedicalVisit> medicalVisits;
}
