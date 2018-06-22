package net.ed.api;

import java.sql.*;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class DB_Test {
	
	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	@BeforeTest
	public void connectToDB() throws SQLException {

		// setup connection with DB YahooScraperMySQLConnection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionString = "jdbc:mysql://yahoo-scraper.cturuocqwdrg.us-east-2.rds.amazonaws.com:3306/yahoo_watchlist_scraper?useSSL=false";
			connect = DriverManager.getConnection(connectionString, "MeAdmin", "M##dm!n!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void connectToDB_Test() throws Exception {
		try {
			System.out.print("connect.toString() == ");
			System.out.println(connect.toString());
		} catch (Exception e) {
			throw e;
		}
	}

}
