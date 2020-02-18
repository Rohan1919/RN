package com.lti.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.lti.entity.Employee;

@Path("/emp")
public class EmployeeService {
	@POST
//	@Consumes("apllication/json")
	public void add(String data,@Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		
		System.out.println(data);
	}
//	public void add(Employee data,@Context HttpServletResponse response) {
//		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
//		
//		System.out.println(data.getDateofJoining());
//		System.out.println(data.getName());
//		System.out.println(data.getSalary());
//		System.out.println(data);
//	}


}
