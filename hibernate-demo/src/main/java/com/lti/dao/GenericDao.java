package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Customer;
import com.lti.entity.Employee;

public class GenericDao {
	
	
	public void upsert(Object obj) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
			
		try{
			emf=Persistence.createEntityManagerFactory("hibernate-demo");
		    em=emf.createEntityManager();
		
		    EntityTransaction tx=em.getTransaction();
		    tx.begin();
		//em.persist(obj); only for insert
		    em.merge(obj);//can be used for both insert and update
		    tx.commit();
		}
		finally {
			em.close();
			emf.close();
			
		}
	}
	//public Object fetchByPK(Class clazz,Object pk){
	public <E> E fetchByPK(Class<E> clazz,Object pk) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		try{
		   emf=Persistence.createEntityManagerFactory("hibernate-demo");
		   em=emf.createEntityManager();
		   return em.find(clazz, pk);
		//find method can be used to fetch data
		// Object obj=em.find(clazz, pk);
		    
		}
		 finally {
		         em.close();
		         emf.close();
		 }
		
		
		
	}
	
	
}
