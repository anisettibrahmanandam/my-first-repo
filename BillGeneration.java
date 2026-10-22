package com;

		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.Statement;
		
		public class BillGeneration{

		    public static void main(String[] args) {

		        String url = "jdbc:mysql://localhost:3306/food_ordering";
		        String user = "root";
		        String password = "800808371@Abn";

		        try {
		           
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            Connection con = DriverManager.getConnection(url, user, password);

		            Statement st = con.createStatement();
		   

		            ResultSet rs = st.executeQuery("SELECT *FROM orders");

		            System.out.println("===== BILL =====");
		            

		            while (rs.next()) {
		                System.out.println("Order ID:"+ rs.getInt("order_id"));
		                      
		                System.out.println("Customer ID:"+rs.getInt("customer_id"));
		                      
		                 System.out.println("Total Amount:"+rs.getDouble("total_amount"));   
		                 
		                System.out.println("--------------------------");
		            }

		            rs.close();
		            st.close();
		            con.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
		
		
		


