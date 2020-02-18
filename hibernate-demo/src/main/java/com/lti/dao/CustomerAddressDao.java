package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Address;
import com.lti.entity.Customer;
import com.lti.entity.Employee;

public class CustomerAddressDao {
	EntityManagerFactory emf=null;
	EntityManager em=null;
	public void add(Customer customer) {
			//here we are using ORM(HIBERNATE) to insert EMP data in DB..
			//step1: create/load EntityManagerFactory Object..
			//during meta -INF/persistance.xml file will be read..
	       //please check the <persistence-unit name>="?" and mention the same below
		
		try {
		    emf=Persistence.createEntityManagerFactory("hibernate-demo");
			
			//step2... create/load EntityManager Object..
			em=emf.createEntityManager();
			
			//step3...Begin/participate in a transaction
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			
			//now we can perform any SQL operation (insert/update/delete/select)
			em.persist(customer);  //HIBERNATE code that provide persist method that fires the insert query..(em.merge() used for update)

			tx.commit();
			
			//should be in finally block..
		}
		finally {
			em.close();
			emf.close();
		}
	}
	public Customer fetchCustomer(int id) {
		Customer cust=null;
		try{
			 emf=Persistence.createEntityManagerFactory("hibernate-demo");
		 
		 em=emf.createEntityManager();
		
		//find method can be used to fetch data
		cust=em.find(Customer.class, id);
		 }
		 finally {
		em.close();
		emf.close();
		 }
		return cust;
		
		
	}
	public void addAddress(Address address) {
		//here we are using ORM(HIBERNATE) to insert EMP data in DB..
		//step1: create/load EntityManagerFactory Object..
		//during meta -INF/persistance.xml file will be read..
       //please check the <persistence-unit name>="?" and mention the same below
	
	try {
	    emf=Persistence.createEntityManagerFactory("hibernate-demo");
		
		//step2... create/load EntityManager Object..
		em=emf.createEntityManager();
		
		//step3...Begin/participate in a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		//now we can perform any SQL operation (insert/update/delete/select)
		em.persist(address);  //HIBERNATE code that provide persist method that fires the insert query..(em.merge() used for update)

		tx.commit();
		
		//should be in finally block..
	}
	finally {
		em.close();
		emf.close();
	}
}
	public void updateCustomer(Customer customer) {
		//here we are using ORM(HIBERNATE) to insert EMP data in DB..
		//step1: create/load EntityManagerFactory Object..
		//during meta -INF/persistance.xml file will be read..
       //please check the <persistence-unit name>="?" and mention the same below
	
	try {
	    emf=Persistence.createEntityManagerFactory("hibernate-demo");
		
		//step2... create/load EntityManager Object..
		em=emf.createEntityManager();
		
		//step3...Begin/participate in a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		//now we can perform any SQL operation (insert/update/delete/select)
		em.merge(customer);  //HIBERNATE code that provide persist method that fires the insert query..(em.merge() used for update)

		tx.commit();
		
		//should be in finally block..
	}
	finally {
		em.close();
		emf.close();
	}
}
	
	public List<Customer> fetchByEmail(String domain){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		String ql="select c from Customer c where c.email like :em";
		//String ql="select c from Customer c where c.email like '%@gmail.com'";
		Query q=em.createQuery(ql);
		q.setParameter("em","%"+domain+"%");
	
		List<Customer> list=q.getResultList();
		em.close();
		emf.close();
		return list;
	}
	public List<Customer> fetchByCity(String city){
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate-demo");
		EntityManager em=emf.createEntityManager();
		String ql="select c from Customer c join c.address a where a.city= :ct";
		//String ql="select c from Customer c where c.email like '%@gmail.com%'";
		Query q=em.createQuery(ql);
		q.setParameter("ct",city);
	
		List<Customer> list=q.getResultList();
		em.close();
		emf.close();
		return list;
	}
		
}


