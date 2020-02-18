package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//bean classes are the part of the model they are used by all the layers
@Entity
@Table(name="ACCOUNT_TABLE1")
public class Account {
	@Id
	@GeneratedValue
	private int acno;
	
	private String name;
	@Column(name="ac_type")
	private String type;
	private double balance;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="account")
	private List<AccountTransaction> account_transaction;

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<AccountTransaction> getAccount_transaction() {
		return account_transaction;
	}

	public void setAccount_transaction(List<AccountTransaction> account_transaction) {
		this.account_transaction = account_transaction;
	}

	

}
