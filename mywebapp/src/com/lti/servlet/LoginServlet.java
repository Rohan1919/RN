package com.lti.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.loginimport.UserService;


@WebServlet("/login.lti")

public class LoginServlet extends HttpServlet {
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	//	 Base64.Encoder encoder = Base64.getEncoder(); 
		// username = encoder.encode(username);
		 String usernamee=Base64.getEncoder().encodeToString(username.getBytes());
		String passwordd=Base64.getEncoder().encodeToString(password.getBytes());
		UserService userService= new UserService();
		boolean isValidUser = userService.isValidUser(username, password);
		
		if(isValidUser){
		
			//checking if remember me option was selected
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")){
				Cookie c1 = new Cookie("uname", usernamee);
				c1.setMaxAge(60*60);// 1hr
				Cookie c2 = new Cookie("pwd", passwordd);
				c2.setMaxAge(60*60);// 1hr
				response.addCookie(c1);
				response.addCookie(c2);
				System.out.println(c1.getValue());
				
				
			}
			
			response.sendRedirect("index.html");
	
		
		
		}
		else
			response.sendRedirect("login.html");
  		
	}



}
