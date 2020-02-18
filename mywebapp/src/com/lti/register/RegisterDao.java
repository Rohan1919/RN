package com.lti.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.RegisterM;

//data access object 
//classes which contain database instruction
//code in java are commonly reffered to as DAO class
public class RegisterDao {
 Connection con=null;
 {
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	 
 }
	
	public boolean insert(RegisterM rm){
		try {
			
			String q="insert into register values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, rm.getName());
			ps.setString(2, rm.getEmail());
			ps.setString(3, rm.getPass());
			ps.setString(4, rm.getCity());
			int a=ps.executeUpdate();
			if(a==1){
				System.out.println("record inserted succefully");
			}
			else{
				System.out.println("unable to insert records");
			}
			return true;
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			try{con.close();}catch(Exception e){
				System.out.println(e);
				}
	}
	}
	public List<RegisterM> search(String city){
		List<RegisterM> l=new ArrayList<RegisterM>();
			try {
				String q="select * from register where city=?";
				PreparedStatement ps=con.prepareStatement(q);
		        ps.setString(1,city);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()){
					RegisterM m=new RegisterM();
					
					m.setName(rs.getString(1));
					m.setEmail(rs.getString(2));
					m.setPass(rs.getString(3));
					m.setCity(rs.getString(4));
					l.add(m);
				}
								
				
				
			} catch ( SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			finally{
				try{con.close();}catch(Exception e){
					System.out.println(e);
					}
		}
		return l;	
		}
	
	}


