package com.lti.app;

import java.time.LocalDate;
import java.util.List;

import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;

public class App {

	public static void main(String[] args) {
//		Employee emp =new Employee();
//		emp.setName("Rohan");
//		emp.setDateofJoining(LocalDate.of(2020, 1, 1));
//		emp.setSalary(26300);
//		
//		EmployeeDao dao=new EmployeeDao();
//		dao.add(emp);
//		
//		Employee emp =new Employee();
//		emp.setName("Mohan");
//		emp.setDateofJoining(LocalDate.of(2020, 3, 1));
//		emp.setSalary(26500);
//		
//		EmployeeDao dao=new EmployeeDao();
//		dao.add(emp);
//		
//		Employee emp =new Employee();
//		emp.setName("Rohan");
//		emp.setDateofJoining(LocalDate.of(2020, 1, 1));
//		emp.setSalary(26300);
//		
//		EmployeeDao dao=new EmployeeDao();
//		dao.add(emp);
//		
//		Employee emp =new Employee();
//		emp.setName("Rohan");
//		emp.setDateofJoining(LocalDate.of(2020, 1, 1));
//		emp.setSalary(26300);
//		
//		EmployeeDao dao=new EmployeeDao();
//		dao.add(emp);
//		
		/*
		 EmployeeDao dao=new EmployeeDao();
		 Employee emp =dao.fetch(1);
		 System.out.println(emp.getName());
		 System.out.println(emp.getDateofJoining());
		 System.out.println(emp.getSalary());
		*/
		
//		EmployeeDao dao =new EmployeeDao();
//		List<Employee> list=dao.fetchBySalary(10000);
//		for(Employee emp1:list) {
//		System.out.println(emp1.getName());
//		System.out.println(emp1.getDateofJoining());
//		System.out.println(emp1.getSalary());
		EmployeeDao dao =new EmployeeDao();
		List<Employee> list=dao.fetchByYear(19);
		for(Employee emp1:list) {
		System.out.println(emp1.getName());
		System.out.println(emp1.getDateofJoining());
		System.out.println(emp1.getSalary());
		
	}
	}

}