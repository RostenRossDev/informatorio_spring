package com.example.Informatorio.restcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Informatorio.dto.PatientDto;
import com.example.Informatorio.entity.Patient;
import com.example.Informatorio.service.IPatientService;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private IPatientService patientService;
	
	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> all(){
		Map<String, Object> response = new HashMap<>();
		List<Patient> patients = new ArrayList<>();
		response.put("pacientes", patients);
		
		if(true) {
			throw new ArithmeticException("No puedes dividir por cero");
		}
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newPatient( @RequestBody @Valid PatientDto patientDto) throws Exception{
		
		log.info("paciente: "+patientDto.toString());
		Map<String, Object> response = new HashMap<>();
		PatientDto newPatient = patientService.save(patientDto);
		response.put("paciente", newPatient);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@RequestBody PatientDto patientDto){
		log.info("paciente: "+patientDto.toString());
		Map<String, Object> response = new HashMap<>();
		PatientDto updatePatient = patientService.save(patientDto);
		
		if(updatePatient == null) {
			response.put("mensaje", "No se pudo actualizar la informacion del paciente.");
		}
		
		response.put("paciente", updatePatient);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/all/birthdate/{date}") 
	public ResponseEntity<Map<String, Object>> allByBirthdate (@PathVariable(name = "date") String birthdateStr){
		log.info("cumpleaños: "+birthdateStr);
		String[] diaMesAnio = birthdateStr.split("-");
		log.info("cumpleaños array: "+diaMesAnio[0]+", "+diaMesAnio[1]+ ", "+diaMesAnio[2]);
		Integer date = Integer.parseInt(diaMesAnio[0]);
		Integer month = Integer.parseInt(diaMesAnio[1]);
		Integer year = Integer.parseInt(diaMesAnio[2]);
		log.info("busqueda 1: "+year+"-"+month+"-"+date);
		
		Date birthdate = new Date(year, month, date);
		Map<String, Object> response = new HashMap<>();
		List<Patient> patiens = patientService.findByBirthdate(birthdate);
		log.info("busqueda 1: "+patiens.toString());
		log.info("birthdateStr : "+birthdateStr);
		log.info("birthdate : "+birthdate);
		patiens = patientService.findByBirthdate(birthdate);
		log.info("busqueda 2: "+patiens.toString());

		patiens = patientService.findByBirthdateLike(birthdate);
		log.info("busqueda 3: "+patiens.toString());

		response.put("patients", patiens);
		response.put("mensaje", "busqueda finalizada con exito.");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
