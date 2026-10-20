package com;

import java.sql.*;

public class updateData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentdb",
					"root",
					"800808371@Abn");
			
			String query=
					"update students set marks=? where student_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, 95);
			ps.setInt(2, 1);
			
			int i=ps.executeUpdate();
			
			System.out.println(i+"Record Updated");
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
						
		}
	}
}
