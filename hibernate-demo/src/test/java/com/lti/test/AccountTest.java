package com.lti.test;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.service.AccountService;

public class AccountTest {
	@Test
	public void openAccountTest() {
		Account acc=new Account();
		acc.setBalance(60000);
		
		acc.setName("Rohan");
		acc.setType("saving");
		AccountService as=new AccountService();
		as.openAccount(acc);
		
	}
	@Test
	public void withdrawBalance() {
		AccountService as=new AccountService();
		as.withdraw(111,5000);
	}
	@Test
	public void depositeMoney() {
		AccountService as=new AccountService();
		as.deposit(111,50000);
	}
	public void transferMoney() {
		AccountService as=new AccountService();
		as.transfer(111,114,20000);
	}

}
