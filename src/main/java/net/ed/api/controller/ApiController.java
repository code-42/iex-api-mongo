package net.ed.api.controller;

// source https://spring.io/guides/gs/consuming-rest/
// this api puts stock data INTO mysql yahoo_watchlist_scraper.stocks table
// yahoo-scraper-spring-hibernate-maven StocksRESTController retrieves this data
// and displays in view/list-equities.jsp

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.ed.api.entity.Stocks;

@JsonIgnoreProperties(ignoreUnknown = true)
@RestController
public class ApiController {
	
	@Autowired
	ApiRepository apiRepository;
	
	String[] symbols = {"AAPL","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","MSFT"};
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
			
		return args -> {
			for(String symbol : symbols) {
				Stocks[] stocks = restTemplate.getForObject(
						"https://api.iextrading.com/1.0/stock/" + symbol + "/chart", Stocks[].class);
				
				for(Stocks stock : stocks) {
					stock.setSymbol(symbol);
					
					if(stock.getDate().equals("2018-08-29")) {
						System.out.println(stock.toString());
						apiRepository.save(stock);
					}
				}
			}
		};
	}
}

