package com.example.Informatorio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Informatorio.InformatorioApplication;
import com.example.Informatorio.entity.Usuario;
import com.example.Informatorio.service.IUsuario;

@Controller
public class UerController {
	
	private static final Logger log = LoggerFactory.getLogger(UerController.class);

	@Autowired
	private IUsuario usuarioService;
	
	
	@GetMapping("/tablaUsuarios")
	public String tablaUsuarios(Model model) {
		log.info("Esto es un mensaje mediante el log");
		List<Usuario> usuarios = usuarioService.findByAll();
		 model.addAttribute("usuarios", usuarios);
		return "index";
	}
	
	
}
