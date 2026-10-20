package com;

import java.sql.*;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Studentdb",
			"root",
			
			"800808371@Abn"); 
			
			String query="delete from students where student_id=?";
			
			PreparedStatement ps= con.prepareStatement(query);
			
			ps.setInt(1,4);
			
			int i=ps.executeUpdate();
			
			System.out.println(i+"Record Deleted");
			
			con.close();
								
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
