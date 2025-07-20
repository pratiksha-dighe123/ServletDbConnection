package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitform")
public class Employee extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid= request.getParameter("empId");
		int id= Integer.parseInt(eid);
		
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        long phoneNo = Long.parseLong(phone);
        String altPhone = request.getParameter("altPhone");
        long altNo = Long.parseLong(phone);
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String doj = request.getParameter("doj");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String pincode = request.getParameter("pincode");
        int pcode= Integer.parseInt(pincode);
        
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/batch227","root","admin");
			PreparedStatement ps= c.prepareStatement("insert into employeeInfo(empId, firstName, lastName, email, password, phone, altPhone, gender, dob, department, designation, doj, address, city, state, country, pincode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,id );
			ps.setString(2,firstName);
			ps.setString(3,lastName);
			ps.setString(4,email);
			ps.setString(5,password);
			ps.setLong(6,phoneNo);
			ps.setLong(7, altNo);
			ps.setString(8,gender);
			ps.setString(9,dob);
			ps.setString(10,department);
			ps.setString(11,designation);
			ps.setString(12,doj);
			ps.setString(13,address);
			ps.setString(14,city);
			ps.setString(15,state);
			ps.setString(16,country);
			ps.setInt(17,pcode);
			
			ps.executeUpdate();
			c.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
        
        
        
        
		
	}
		

}
