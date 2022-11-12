package com.example.Informatorio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Informatorio.entity.User;
import com.example.Informatorio.service.IUser;

@Controller
public class UerController {
	
	private static final Logger log = LoggerFactory.getLogger(UerController.class);

	@Autowired
	private IUser usuarioService;
	
	
	@GetMapping("/tablaUsuarios")
	public ModelAndView tablaUsuarios() {
		ModelAndView mav = new ModelAndView();
		log.info("Esto es un mensaje mediante el log");
		List<User> usuarios = usuarioService.findByAll();
		log.info("Long: "+usuarios.size());
		log.info("usuarios: "+usuarios.toString());
		mav.addObject("usuarios", usuarios);
		mav.addObject("long", usuarios.size());
        mav.setViewName("index");
		return mav;
	}
	
	
}
