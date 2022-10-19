package com.example.Informatorio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Informatorio.entity.Usuario;
import com.example.Informatorio.repository.IUsuarioDao;

@Service
public class IUsuarioImpl implements IUsuario{

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(new Usuario());
	}

	@Override
	public List<Usuario> findByAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

}
