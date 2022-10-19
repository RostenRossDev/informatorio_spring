package com.example.Informatorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Informatorio.entity.Usuario;
import com.example.Informatorio.servicio.IUsuario;

@Controller
public class UerController {

	@Autowired
	private IUsuario usuarioService;
	
	
	@GetMapping("/tablaUsuarios")
	public String tablaUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.findByAll();
		 model.addAttribute("usuarios", usuarios);
		return "index";
	}
}
