package com.example.Informatorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Informatorio.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{

	
}
