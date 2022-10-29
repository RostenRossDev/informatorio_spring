package com.example.Informatorio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Informatorio.controller.UerController;
import com.example.Informatorio.entity.User;
import com.example.Informatorio.repository.IUserDao;

@Service
public class IUserImpl implements IUser{
	private static final Logger log = LoggerFactory.getLogger(IUserImpl.class);

	@Autowired
	IUserDao usuarioDao;
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		log.info("buscando usuario por id");
		return usuarioDao.findById(id).orElse(new User());
	}

	@Override
	public List<User> findByAll() {
		// TODO Auto-generated method stub
		log.info("buscando todos los usuarios");
		log.debug("buscando todos los usuarios");
		return usuarioDao.findAll();
	}

}
