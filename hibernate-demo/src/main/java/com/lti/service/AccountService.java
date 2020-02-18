package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.AccountTransaction;

//classes containing business logic commanly reffered to
//as Service class
public class AccountService {
	//TODo:
	//1.check if the user has enough money to open an account
	//2.store account details in the database if the above condition is met
	//3\.throw an exception if the above condition is not met
	//4.if step 2. execute successfully then send to the customer
	public void openAccount(Account acc) {
		if(acc.getBalance()>=5000) {
		GenericDao dao=new GenericDao();
		dao.upsert(acc);
		//code to send email will be here
		}
		else {
			//throw new AccountException("sorry,minimum balance of 5000")
		}
	}
	public void withdraw(int acno,double amount) {
		GenericDao dao=new GenericDao();
		AccountTransaction at=new AccountTransaction();
	   
	    Account ac=dao.fetchByPK(Account.class, acno);
	   if(ac.getBalance()>=amount) {
	    ac.setBalance(ac.getBalance()-amount);
	    dao.upsert(ac);
	    at.setAmount(amount);
	   
	    at.setDateAndTime(LocalDate.now());
	    at.setType("withdraw");
	   // System.out.println(at.getTxno()+"  "+at.getAccount()+"  "+at.getDateAndTime()+"  "+at.getAmount());
	   
	    at.setAccount(ac);
	    
		   
	    dao.upsert(at);
	   }
	   else {
		   //throw new Exception("sorry not able to dupdate");
	   }
	   
		
	}
    public void deposit(int acno,double amount) {
    	GenericDao dao=new GenericDao();
    	Account ac=dao.fetchByPK(Account.class, acno);
		ac.setBalance(ac.getBalance()+amount);
		dao.upsert(ac);
		AccountTransaction at=new AccountTransaction();
		at.setAccount(ac);
		at.setAmount(amount);
		at.setDateAndTime(LocalDate.now());
		at.setType("deposit");
		dao.upsert(at);
		
	}
    public void transfer(int fromacno,int acno,double amount) {
		GenericDao dao=new GenericDao();
    	Account fac=dao.fetchByPK(Account.class, fromacno);
    	Account ac=dao.fetchByPK(Account.class, acno);
    	//fac.setBalance(balance);
    	
	}
    public double checkBalance(int accno) {
		return 10;
	}

}
