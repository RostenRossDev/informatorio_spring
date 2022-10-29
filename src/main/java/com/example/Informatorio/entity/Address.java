package com.example.Informatorio.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_street", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="street_id"))
	private Set<Street> street;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_number", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="number_id"))
	private Set<NumberStreet> number;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_department", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="department_id"))
	private Set<Departament> department;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_floor", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="floor_id"))
	private Set<Floor> floor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Set<Street> getRoles() {
		return street;
	}

	public void setRoles(Set<Street> roles) {
		this.street = roles;
	}

	public Set<NumberStreet> getNumber() {
		return number;
	}

	public void setNumber(Set<NumberStreet> number) {
		this.number = number;
	}

	public Set<Departament> getDepartment() {
		return department;
	}

	public void setDepartment(Set<Departament> department) {
		this.department = department;
	}

	public Set<Floor> getFloor() {
		return floor;
	}

	public void setFloor(Set<Floor> floor) {
		this.floor = floor;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, Set<Street> street, Set<NumberStreet> number, Set<Departament> department,
			Set<Floor> floor) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.department = department;
		this.floor = floor;
	}

	
}
