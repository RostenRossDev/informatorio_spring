package com.example.Informatorio.restcontroller;

import java.sql.SQLTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
	public ResponseEntity<HashMap<String, Object>> todosLosUsuarios() throws ArithmeticException {
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (true)throw new ArithmeticException("no se puede dividir por cero");
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
	
	
	@GetMapping("/user/{nombre}")
	public ResponseEntity<HashMap<String, Object>> buscarPorNombre(@PathVariable(name = "nombre") String nombre) throws NotFoundException{
		HashMap<String, Object> response = new HashMap<String, Object>();

		if(nombre.equals("Nestor")) {
			throw new NotFoundException();
		}
		response.put("mensaje", "El usuario con nombre ".concat(nombre).concat(" existe"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/usuario/{apellido}")
	public ResponseEntity<HashMap<String, Object>> buscarPorApellido(@PathVariable(name = "nombre") String apellido) throws SQLTimeoutException{
		HashMap<String, Object> response = new HashMap<String, Object>();

		if(apellido.equals("Costantini")) {
			throw new SQLTimeoutException();
		}
		response.put("mensaje", "El usuario con apellido ".concat(apellido).concat(" existe"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/ejecutar/ddl")
	public ResponseEntity<HashMap<String, Object>> commandAcceptanceException() throws CommandAcceptanceException{
		HashMap<String, Object> response = new HashMap<String, Object>();

		if(true) {
			throw new CommandAcceptanceException("Error al ejecutar ddl");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
