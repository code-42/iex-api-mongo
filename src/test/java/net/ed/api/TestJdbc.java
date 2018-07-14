package net.ed.api;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/yahooscraper?useSSL=false";
		String user = "yahoo";
		String pass = "yahoo";
		
		try {
			System.out.println("Connecting to db: " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
