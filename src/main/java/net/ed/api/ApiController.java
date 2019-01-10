package net.ed.api;

/*
 * Copyright 2019 Edward Dupre 
 */

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import net.ed.api.JsonDecoder;

@Component
public class ApiController implements CommandLineRunner {
	
	// empty constructor
	public ApiController() {}
	
	// CommandLineRunner executed after the application context is loaded
	public void run(String... args) throws Exception {
		
		// format date to match iex api
		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("28. yesterday == " + yesterday.format(dateFmt));
		
		// array of stock symbols to get data from iex
		String[] symbols = {"AAPL","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","MSFT"};
		
		try {
			// loop through symbols array
			for(String symbol : symbols) {
				// send api request with embedded stock symbol
				URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/chart");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				
				// test response code
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			
				// read text from a input stream,
				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
				
				String output; // looks like array of Json objects but is String
				while ((output = br.readLine()) != null) {
					// send input stream for processing
					JsonDecoder.jsonDecoder(symbol, output);
				}
				// be nice and disconnect when done
				conn.disconnect();
			}  // end for
	
			// exception handling
		  } catch (MalformedURLException e) {
		
			e.printStackTrace();
		
		  } catch (IOException e) {
		
			e.printStackTrace();
		
		  } catch (Exception e) {
				
			e.printStackTrace();
		
		  }
		// bye
		System.exit(0);
	}
}
