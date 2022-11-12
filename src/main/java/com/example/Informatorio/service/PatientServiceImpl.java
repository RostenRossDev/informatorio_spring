package com.example.Informatorio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Informatorio.dto.PatientDto;
import com.example.Informatorio.entity.Patient;
import com.example.Informatorio.repository.IPatientDao;
import com.example.Informatorio.wrapper.PatientWrapper;

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
	
	@Override
	public List<Patient> findByBirthdateLike(Date birthdate) {
		// TODO Auto-generated method stub
		List<Patient> patients =  patientDao.findByBirthdateLike(birthdate);
		return patients;
	}
	
	@Override
	public List<Patient> findByBirthdateQuery(Date birthdate){
	// TODO Auto-generated method stub
	List<Patient> patients =  patientDao.findByBirthdateQuery(birthdate);
	return patients;
	}

	@Override
	public PatientDto save(PatientDto patientDto) {
		Patient patient = PatientWrapper.dtoToEntity(patientDto);
		patient = patientDao.save(patient);
		patientDto = PatientWrapper.entityToDto(patient);
		return patientDto;
	}

	@Override
	public PatientDto update(PatientDto patientDto) {
		Patient patientExist = patientDao.findByDni(patientDto.getDni());
		//Patient patient = PatientWrapper.dtoToEntity(patientDto);
		if(patientExist != null) {
			
			Patient entityToPersist = new Patient(); //creamos el objeto a persistir con campos nulos
			
			// seteamos los valores al objeto a persistir
			entityToPersist.setId(patientExist.getId());
			entityToPersist.setDni(patientDto.getDni());
			entityToPersist.setLastname(patientDto.getLastname());
			entityToPersist.setName(patientDto.getName());
			entityToPersist.setMedicaAssurance(patientDto.getMedicaAssurance());
			entityToPersist.setBirthdate(patientDto.getBirthdate());
			//
			
			//persistimos el objeto
			patientExist = patientDao.save(entityToPersist);
			patientDto = PatientWrapper.entityToDto(patientExist);
			return patientDto;
		}
		
		
		return null;
	}

	@Override
	public PatientDto findByDni(Integer dni) {
		Patient patient = patientDao.findByDni(dni);	
		return PatientWrapper.entityToDto(patient);
	}
	
}
