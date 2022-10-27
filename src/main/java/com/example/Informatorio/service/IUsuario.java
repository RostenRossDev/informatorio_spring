package com.example.Informatorio.service;

import java.util.List;

import com.example.Informatorio.entity.Usuario;

public interface IUsuario {

	public Usuario findById(Long id);
	public List<Usuario> findByAll();
	
}
