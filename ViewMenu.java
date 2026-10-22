package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ViewMenu {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_ordering",
                    "root",
                    "800808371@Abn");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select*from menu");
            
            System.out.println("MENU LIST");
            
            while(rs.next()){
            	System.out.println(
            	
            	rs.getInt("item_id")+""
            	+rs.getString("item_name")+""
            	+rs.getDouble("price")
            	);
            }

            con.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

	


