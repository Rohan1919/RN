package com.lti.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;



@WebServlet("/register.lti")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading data

		RegisterM rm=new RegisterM();
		//reading form data and storing it in object
		
		RegisterDao dao=new RegisterDao();
		
		
		rm.setName(request.getParameter("name"));
		rm.setEmail(request.getParameter("email"));
		rm.setPass(request.getParameter("password"));
		rm.setCity(request.getParameter("city"));
		
		
		boolean done=dao.insert(rm);
		
		if(done)
		{
			response.sendRedirect("confirmation.html");
		}
		else
			response.sendRedirect("error.html");

			
		}
		
	}
		

