package com.example.Informatorio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Informatorio.entity.Patient;
import com.example.Informatorio.repository.IPatientDao;

@Service
public class PatientServiceImpl implements IPatientService{

	@Autowired
	private IPatientDao patientDao;
	
	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		return patientDao.findAll();
	}

	@Override
	public Patient findById(Long id) {
		// TODO Auto-generated method stub
		return patientDao.findById(id).orElse(new Patient());
	}

	@Override
	public List<Patient> findByBirthdate(Date birthdate) {
		// TODO Auto-generated method stub
		List<Patient> patients =  patientDao.findByBirthdate(birthdate);
		return patients;
	}

}
