package com.example.Informatorio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

//@Entity(name="addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "addresse_id_street_id", 
        joinColumns = { @JoinColumn(name = "addresse_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "street_id")} , 
        uniqueConstraints = {@UniqueConstraint(columnNames = {"addresse_id","street_id"})}
    )
	private Street street;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "addresse_id_number_id", 
        joinColumns = { @JoinColumn(name = "addresse_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "number_id")} , 
        uniqueConstraints = {@UniqueConstraint(columnNames = {"addresse_id","number_id"})}
    )
	private NumberStreet number;	
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "addresse_id_department_id", 
        joinColumns = { @JoinColumn(name = "addresse_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "department_id")} , 
        uniqueConstraints = {@UniqueConstraint(columnNames = {"addresse_id","department_id"})}
    )
	private Departament department;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "addresse_id_floor_id", 
        joinColumns = { @JoinColumn(name = "addresse_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "floor_id")} , 
        uniqueConstraints = {@UniqueConstraint(columnNames = {"addresse_id","floor_id"})}
    )
	private Floor floor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public NumberStreet getNumber() {
		return number;
	}

	public void setNumber(NumberStreet number) {
		this.number = number;
	}

	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
		this.department = department;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, Street street, NumberStreet number, Departament department, Floor floor) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.department = department;
		this.floor = floor;
	}
	
	
}
