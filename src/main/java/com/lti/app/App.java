package com.lti.app;

import java.time.LocalDate;

import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;

public class App {
	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setName("majrul");
		emp.setDateOfJoining(LocalDate.of(2020,1,1));
		emp.setSalary(100000000);
		EmployeeDao dao=new EmployeeDao();
		dao.add(emp);
		
		emp=dao.fetch(1);
		System.out.println(emp.getDateOfJoining());
		System.out.println(emp.getPsno());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		
	}

}
