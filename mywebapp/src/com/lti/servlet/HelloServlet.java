package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/google.py")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hey Guys I am 20 Years Old technology !!!!!!!!!</h1>");
		out.println("<h2>Aj ki tarikh : "+LocalDate.now()+" hai </h2>");
		out.println("<a href='index.html'>hey</a>");
		out.println("</body></html>");
		
	}

}
