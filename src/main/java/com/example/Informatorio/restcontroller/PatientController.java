package com.example.Informatorio.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Informatorio.entity.Patient;

@RestController
public class PatientController {

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> all(){
		Map<String, Object> response = new HashMap<>();
		List<Patient> patients = new ArrayList<>();
		response.put("pacientes", patients);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
}
