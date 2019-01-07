package net.ed.api;

// https://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import net.ed.api.JsonDecoder;
import org.json.JSONArray;

@Component
public class RestClient implements CommandLineRunner {
	
//	public static void GetRest() {
	public void run(String... args) throws Exception {
		
		System.out.println("Helllllooooo");
		
		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("28. yesterday == " + yesterday.format(dateFmt));
		
		String[] symbols = {"AAPL","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","MSFT"};

		
		try {
			for(String symbol : symbols) {
				
//				System.out.println("inside try block...");
				URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/chart");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
			
				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
				
				String output;
				while ((output = br.readLine()) != null) {
					JsonDecoder.jsonDecoder(symbol, output);
						
				}
				
				// looking for one date only
//				String theDate = "2018-12-27";
//				if(output.toLowerCase().contains(theDate)) {
//					System.out.println(output);
//				}
				conn.disconnect();
			}
	
		  } catch (MalformedURLException e) {
		
			e.printStackTrace();
		
		  } catch (IOException e) {
		
			e.printStackTrace();
		
		  }
		System.exit(0);
	}
}
