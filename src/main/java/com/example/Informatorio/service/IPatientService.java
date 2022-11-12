package com.example.Informatorio.service;

import java.util.Date;
import java.util.List;

import com.example.Informatorio.dto.PatientDto;
import com.example.Informatorio.entity.Patient;

public interface IPatientService {

	public List<Patient> getAll();
	
	public Patient findById(Long id);
	
	public List<Patient> findByBirthdate(Date Birthdate );
	
	public List<Patient> findByBirthdateLike(Date birthdate);
	
	public List<Patient> findByBirthdateQuery(Date birthdate);

	public PatientDto save(PatientDto patient);
	
	public PatientDto findByDni(Integer dni);

	public PatientDto update(PatientDto patientDto);

}

