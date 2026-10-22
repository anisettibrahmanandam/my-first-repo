package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PlaceOrder{ 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/food_ordering";
        String user = "root";
        String password = "800808371@Abn";

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, user, password);


            System.out.print("Enter Food Item Name: ");
             sc.nextLine();
           

            System.out.print("Enter Quantity: ");


            String sql = "INSERT INTO orders(customer_id, total_amount) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            System.out.print("Enter Customer Id:");
            int customerId = sc.nextInt();
            
            System.out.print("Enter Total Amount:");
            double totalamount = sc.nextDouble();

            ps.setInt(1, customerId);
            ps.setDouble(2, totalamount);
		
         

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Order Placed Successfully!");
                
            } else {
                System.out.println("Order Failed!");
            }

            ps.close();
            con.close();
            }

            catch (Exception e) {
            e.printStackTrace();
            }

        sc.close();
    }// main method close
    
} // class close
   
