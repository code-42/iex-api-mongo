package net.ed.api.controller;

import java.util.ArrayList;
import java.util.List;

// source https://spring.io/guides/gs/consuming-rest/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import net.ed.api.entity.Chart;
import net.ed.api.entity.Stocks;

@JsonIgnoreProperties(ignoreUnknown = true)
@RestController
public class ApiController {
	
	@Autowired
	ApiRepository apiRepository;
	
	String[] symbols = {"MSFT","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","AAPL"};
	
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
				System.out.println(symbol);
				
				for(Stocks stock : stocks) {
					stock.setSymbol(symbol);
					System.out.println(stock.toString());
					
					apiRepository.save(stock);
				}
			}
		};
	}
}

