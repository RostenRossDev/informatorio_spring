package com.example.Informatorio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.Informatorio.entity.Patient;

@Repository
public interface IPatientDao extends JpaRepository<Patient, Long>{

	@Query("select u from patients u where u.birthdate = ?1")
	public List<Patient> findByBirthdateQuery(Date birthdate);
	
	public List<Patient> findByBirthdateLike(Date birthdate);
	
	public List<Patient> findByBirthdate(Date birthdate);
	
	public Patient findByDni(Integer dni);
}
