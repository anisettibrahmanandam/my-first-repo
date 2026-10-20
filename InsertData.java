package com;

import java.sql.*;

public class InsertData {
	
	public static void main(String[]args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentdb",
					"root",
					
					"800808371@Abn");
			
			String query =
					"insert into students(Student_name,course,attendance,marks)values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "Ramesh");
			ps.setString(2,"Java");
			ps.setDouble(3, 91.5);
			ps.setInt(4,89 );
			
			int i = ps.executeUpdate();
			
			System.out.println(i+"Record Inserted");
			
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

			
		
	


