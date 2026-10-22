package com;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;


public class CustomerRegistration {

	public static void main(String[] args) {
	
		try {
		
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/food_ordering",
					"root",
					"800808371@Abn"
					);
			
			String query =
					"insert into customers(customer_name,phone,address)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,"Ramesh");
			ps.setString(2,"9876543210");
			ps.setString(3,"Hyderabad");
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				System.out.println("Customers Registered Successfully");
			} else {
				
				System.out.println("Registration Failed");
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
