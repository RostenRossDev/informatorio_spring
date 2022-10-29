package com.example.Informatorio.restcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Informatorio.entity.Patient;
import com.example.Informatorio.service.IPatientService;
import com.example.Informatorio.service.PatientServiceImpl;

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
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newPatient(@RequestBody Patient patient){
		log.info("paciente: "+patient);
		Map<String, Object> response = new HashMap<>();
		List<Patient> patients = new ArrayList<>();
		response.put("paciente", patient);
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
		Date birthdate = new Date(date, month , year);
		Map<String, Object> response = new HashMap<>();
		List<Patient> patiens = patientService.findByBirthdate(birthdate);
		response.put("patients", patiens);
		response.put("mensaje", "busqueda finalizada con exito.");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
