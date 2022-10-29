package com.example.Informatorio.service;

import java.util.List;

import com.example.Informatorio.entity.User;

public interface IUser {

	public User findById(Long id);
	public List<User> findByAll();
	
}
