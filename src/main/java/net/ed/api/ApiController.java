package net.ed.api;

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
	
	public void run(String... args) throws Exception {
		
		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("28. yesterday == " + yesterday.format(dateFmt));
		
		String[] symbols = {"AAPL","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","MSFT"};
		
		try {
			for(String symbol : symbols) {
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
				
				String output; // looks like array of Json objects but is String
				while ((output = br.readLine()) != null) {
					JsonDecoder.jsonDecoder(symbol, output);
				}
				conn.disconnect();
			}  // end for
	
		  } catch (MalformedURLException e) {
		
			e.printStackTrace();
		
		  } catch (IOException e) {
		
			e.printStackTrace();
		
		  } catch (Exception e) {
				
			e.printStackTrace();
		
		  }
		System.exit(0);
	}
}
