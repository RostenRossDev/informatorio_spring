package com.example.Informatorio.service;

import java.util.Date;
import java.util.List;

import com.example.Informatorio.entity.Patient;

public interface IPatientService {

	public List<Patient> getAll();
	
	public Patient findById(Long id);
	
	public List<Patient> findByBirthdate(Date Birthdate );
}

