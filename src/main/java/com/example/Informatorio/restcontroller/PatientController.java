package com.example.Informatorio.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Informatorio.entity.Patient;

@RestController
public class PatientController {
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
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
}
