package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Employee;

public class EmployeeDao {
	
	public void add(Employee emp) {
		//we will take help of Orm (Hibernate) to insert employee data in db 
		// step1: Create/Load EntityManagerFactory object
		//During this step,META-INF/persistance.xml file will be read
		//please check the <persistent-unit name="?" and mention the same below
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		//step2:create /load EntityManager object
		EntityManager em=emf.createEntityManager();
		//step3:begin/participation in a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		//Now we can perform any sql operation(insert/delete/update/select
		em.persist(emp);
		tx.commit();
		//should be finally block
		em.close();
		emf.close();
	}
	
	public Employee fetch(int psno) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		//find method is commonly used to fetch data based on pk
		//find method will generate :select * from tbl where pk_col=?
		Employee emp=em.find(Employee.class,psno);
		em.close();
		emf.close();
		return emp;
	}
} 
