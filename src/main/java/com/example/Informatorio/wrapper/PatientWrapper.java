package com.example.Informatorio.wrapper;

import com.example.Informatorio.dto.PatientDto;
import com.example.Informatorio.entity.Patient;

public class PatientWrapper {

	public static Patient dtoToEntity(PatientDto dto) {		
		if(dto == null) return new Patient();
		
		Patient entity = new Patient();
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		entity.setDni(dto.getDni());
		entity.setBirthdate(dto.getBirthdate());
		entity.setMedicaAssurance(dto.getMedicaAssurance());
		
		return entity;
	}
	
	public static PatientDto entityToDto(Patient entity) {
		if(entity == null) return new PatientDto();
		
		PatientDto dto = new PatientDto();
		dto.setName(entity.getName());
		dto.setLastname(entity.getLastname());
		dto.setDni(entity.getDni());
		dto.setBirthdate(entity.getBirthdate());
		dto.setMedicaAssurance(entity.getMedicaAssurance());
		
		return dto;
	}
}
