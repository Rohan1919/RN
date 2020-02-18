package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMP")
public class Employee {
 @Id //pk
 @GeneratedValue //auto generated value
	private int psno;
	private String name;
	
	@Column(name= "DOJ")
	private LocalDate dateofJoining;
	public int getPsno() {
		return psno;
	}
	public void setPsno(int psno) {
		this.psno = psno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateofJoining() {
		return dateofJoining;
	}
	public void setDateofJoining(LocalDate dateofJoining) {
		this.dateofJoining = dateofJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	private double salary;

}
