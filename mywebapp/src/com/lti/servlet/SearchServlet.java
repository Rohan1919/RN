package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RegisterM rm=new RegisterM();
		//reading form data and storing it in object
	
		RegisterDao dao=new RegisterDao();
		PrintWriter out=response.getWriter();
		List<RegisterM> l=new ArrayList<RegisterM>();
			String city=request.getParameter("city1");
			l=dao.search(city);
			for(RegisterM r:l){
			out.println("<html><body><h1>Name : "+r.getName()+"<br>");
			out.println("Email is: "+r.getEmail()+"<br>");
		     out.println("password is: "+r.getPass()+"<br>");
			out.println("city:"+r.getCity()+"</h1></body></html>");
			}
			
		}
		
	}

