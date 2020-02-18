package com.lti.test;

import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerAddressDao;
import com.lti.entity.Address;
import com.lti.entity.Customer;

public class CustomerAddressTest {
	@Test
	public void addCustomer() {
		Customer cust=new Customer();
		cust.setName("Majrul");
		cust.setEmail("Majrul@gmail.com");
		CustomerAddressDao dao=new CustomerAddressDao();
		dao.add(cust);
	}
	@Test
	public void addAddressForExistingCustomer() {
	
		CustomerAddressDao dao=new CustomerAddressDao();
		Address address=new Address();
		address.setCity("pune");
		address.setCountry("India");
		address.setZipcode(411057);
		dao.addAddress(address);
		Customer cust=dao.fetchCustomer(42);
		cust.setAddress(address);
		dao.updateCustomer(cust);
	}
	@Test
	public void addCustomerAlongWithAddress() {
		CustomerAddressDao dao=new CustomerAddressDao();
		
		Customer cust=new Customer();
		cust.setName("rohan");
		cust.setEmail("rohan@gmail.com");
		
		Address addr=new Address();
		addr.setCity("akot");
		addr.setCountry("India");
		addr.setZipcode(444101);
		
		cust.setAddress(addr);
		dao.add(cust);
	}
	@Test
	public void searchByEmail() {
		CustomerAddressDao dao=new CustomerAddressDao();
		List<Customer> c=dao.fetchByEmail("@gmail.com");
		Address ad=null;
		for(Customer l: c) {
			
		    ad=l.getAddress();
		    System.out.println("\nemail"+l.getEmail()+"\nName "+l.getName()+"\nAddress:");
		    if(ad!=null) {
		    System.out.println(ad.getCity());
		}
		    }
	}
	@Test
	public void searchByCity() {
		CustomerAddressDao dao=new CustomerAddressDao();
		List<Customer> c=dao.fetchByCity("akot");
		Address ad=null;
		for(Customer l: c) {
			ad=l.getAddress();
			System.out.println("\nId: "+l.getId()+"\nemail"+l.getEmail()+"\nName "+l.getName()+"\nAddress:"+ad.getCity());
		}
	}

}
