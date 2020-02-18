package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Employee;

public class EmployeeDao {

	public void add(Employee emp) {
		//here we are using ORM(HIBERNATE) to insert EMP data in DB..
		//step1: create/load EntityManagerFactory Object..
		//during meta -INF/persistance.xml file will be read..
		//please check the <persistence-unit name>="?" and mention the same below
	
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		
		//step2... create/load EntityManager Object..
		EntityManager em=emf.createEntityManager();
		
		//step3...Begin/participate in a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		//now we can perform any SQL operation (insert/update/delete/select)
		em.persist(emp);  //HIBERNATE code that provide persist method that fires the insert query..(em.merge() used for update)

		tx.commit();
		
		//should be in finally block..
		em.close();
		emf.close();
	}
	
	public Employee fetch(int psno) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		
		//find method can be used to fetch data
		Employee emp=em.find(Employee.class, psno);
		
		em.close();
		emf.close();
		
		return emp;
		
		
	}
	public List<Employee> fetchBySalary(double salary){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		String ql="select e from Employee e where salary >= :sal";
		Query q=em.createQuery(ql);
		q.setParameter("sal",salary);
		List<Employee> list=q.getResultList();
		em.close();
		emf.close();
		return list;
	}
	public List<Employee> fetchByYear(int year){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
//		String ql="select e from Employee e where extract(year from DOJ) >= :year";
		String ql="select e from Employee e where extract(year from e.dateofJoining) >= :yr";
		//String ql="select e from Employee e where year(dateofJoining):"
		Query q=em.createQuery(ql);
		q.setParameter("yr",year);
		List<Employee> list=q.getResultList();
		em.close();
		emf.close();
		return list;
	}
}



