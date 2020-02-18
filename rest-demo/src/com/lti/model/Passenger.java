package com.lti.model;

import javax.ws.rs.core.Response.Status;

public class Passenger {
	private String name;
	private String age;
	private Gender gender;
	private Status status;
	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	public Passenger(String name, String age, Gender gender, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.status = status;
	}
	public static enum Gender{
		MALE,FEMALE,OTHERS;
	}
	public static enum Status{
		WAITING,RAC,CONFIRMED;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

		
	}

	


