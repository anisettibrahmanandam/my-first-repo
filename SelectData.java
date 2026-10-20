package com;

import java.sql.*;

public class SelectData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentdb",
					"root",
					"800808371@Abn");
			
			System.out.println("Connected Successfully");
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select* from students");
			while(rs.next()) {
				System.out.println(rs.getInt("student_id")+""
				+rs.getString("student_name")+""
				+rs.getString("course")+""
				+rs.getDouble("attendance")+""+rs.getInt("marks"));
				
			}
			
			con.close();
		
		}catch(Exception e) {
			System.out.print(e);
		}
					
		}
	}


