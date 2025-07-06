package com.radhey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String city,state;
	
	@OneToOne(mappedBy = "address")
	private Employee emp;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Address(int id, String city, String state, Employee emp) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.emp = emp;
	}
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + "]";
	}
	
}
