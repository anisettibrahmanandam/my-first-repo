package com;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderHistory {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/food_ordering";
        String user = "root";
        String password = "800808371@Abn";

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url,user,password);
        	
        System.out.println("Connected Successfully");
       
            String query = "SELECT * FROM orders";

         Statement st =con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM orders");

            

            while (rs.next()) {
            	
                System.out.println(
                        rs.getInt("order_id")+""
                        +
                        rs.getInt("customer_id")+""
                        +
                        
                        rs.getDate("order_date")+""
                        +
                        rs.getDouble("total_amount"));
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


