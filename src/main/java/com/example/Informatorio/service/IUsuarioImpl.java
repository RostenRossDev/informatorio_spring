package com.example.Informatorio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Informatorio.controller.UerController;
import com.example.Informatorio.entity.Usuario;
import com.example.Informatorio.repository.IUsuarioDao;

@Service
public class IUsuarioImpl implements IUsuario{
	private static final Logger log = LoggerFactory.getLogger(IUsuarioImpl.class);

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		log.info("buscando usuario por id");
		return usuarioDao.findById(id).orElse(new Usuario());
	}

	@Override
	public List<Usuario> findByAll() {
		// TODO Auto-generated method stub
		log.info("buscando todos los usuarios");
		log.debug("buscando todos los usuarios");
		return usuarioDao.findAll();
	}

}
