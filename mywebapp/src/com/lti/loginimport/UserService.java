package com.lti.loginimport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

	private List<User> users;
	
	public UserService() {
		users= new ArrayList<>();
		users.add(new User("harshal","123",false));
		users.add(new User("Rushi","68",true));
		users.add(new User("gaitonde","768",true));
		users.add(new User("Faisal","456",true));
		
	}

	public boolean isValidUser(String username, String password){
		//System.out.println(username+password);
		for (User u : users){
			if(u.getUsername().equals(username))
				if( u.getPassword().equals(password))
					if( u.isAllowed())
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter values: ");
		Scanner s = new Scanner(System.in);
		String username = s.next();
		//System.out.println(username);
		String password = s.next();
		//System.out.println(password);
		
		UserService mgr = new UserService();
		boolean isValid = mgr.isValidUser(username,password);
		if(isValid)
			System.out.println("Congrats !!!!!");
		else
			System.out.println("Invalid username/Password naya ");
	}

}