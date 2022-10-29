package com.example.Informatorio.restcontroller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Informatorio.entity.User;
import com.example.Informatorio.service.IUser;

@RestController
public class UsuarioController {
	private Logger log = LoggerFactory.getLogger(UsuarioController.class);
	@Autowired
	private IUser usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<HashMap<String, Object>> todosLosUsuarios(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<User> usuarios = usuarioService.findByAll();
		response.put("usuarios", usuarios);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<HashMap<String, Object>> usuario(@PathVariable(value = "id") Long id){
		HashMap<String, Object> response = new HashMap<String, Object>();
		User usuario = usuarioService.findById(id);
		response.put("usuario", usuario);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
}
