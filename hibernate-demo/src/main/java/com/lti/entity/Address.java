package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ADDR")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="addr_id")
	private int id;
	
	private String city;
	private String country;
	private int zipcode;
	
	@OneToOne(mappedBy="address")
	private Customer customer;

	public Address() {
		
	}
	public Address(int id, String city, String country, int zipcode, Customer customer) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.customer = customer;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
