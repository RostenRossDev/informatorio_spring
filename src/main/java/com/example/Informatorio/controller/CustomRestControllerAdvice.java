package com.example.Informatorio.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomRestControllerAdvice extends ResponseEntityExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(CustomRestControllerAdvice.class);
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<>(body, headers, status);
	}	
	
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex) {
		log.info("capturando");
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", new Date());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		body.put("errors", ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException (NotFoundException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", new Date());
		body.put("statusMessage", HttpStatus.NOT_FOUND);
		body.put("statusCode", HttpStatus.NOT_FOUND.value());
		body.put("errors", "El recurso no fue encontrado");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	//CommandAcceptanceException
	
	@ExceptionHandler(CommandAcceptanceException.class)
	public ResponseEntity<Object> handleCommandAcceptanceException (CommandAcceptanceException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", new Date());
		body.put("statusMessage", HttpStatus.INTERNAL_SERVER_ERROR);
		body.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("errors", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
