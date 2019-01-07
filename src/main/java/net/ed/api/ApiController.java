package net.ed.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import net.ed.api.ApiRepository;

import net.ed.api.Stocks;

//@EnableScheduling
@SpringBootApplication
@RestController
@Component
public class ApiController { // implements CommandLineRunner {
	
//	@Autowired
	private ApiRepository apiRepository;
	
//	public ApiController(ApiRepository apiRepository) {
//		this.apiRepository = apiRepository;
//	}
	
	@PostMapping
	public void save(Stocks stock) {
		this.apiRepository.insert(stock);
	}
	
	String[] symbols = {"AAPL","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","MSFT"};
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
    public void buildJson(String[] stock) {
    	String keys[] = {"symbol","market_date","open","high","low","close","volume"};
//    	String values[] = {"AMZN", "2019-01-04","1530.0","1594.0","1518.31","1575.39","9182575"};
    	String values[] = stock;
    	System.out.println(stock.toString());
    	    	String stockJson = "{";
    	for (int i = 0; i < keys.length; i++) {
	    	stockJson += "'" + keys[i] + "':'" + values[i + 1] + "'";
	    	if(i < keys.length - 1) { stockJson += ",";}
    	}
    	stockJson += "}";
    	System.out.println(stockJson);
	};
	
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//	public void run() throws Exception {
	public void run() throws Exception {
		
		System.out.println("Helllllooooo");

		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("61. yesterday == " + yesterday.format(dateFmt));
		
//		List<Stocks> stocksArr = Arrays.asList();
		
//		return args -> {
//			for(String symbol : symbols) {
//				System.out.println(symbol);
//				String[] stocks = restTemplate.getForObject(
//					"https://api.iextrading.com/1.0/stock/" + symbol + "/chart", String[].class);
////
//				for(String stock : stocks) {
//					stock.setSymbol(symbol);
//					System.out.println(stock.toString());
//					if(stock.date().equals("2018-12-27")) {
//					if(stock.getDate().equals(yesterday.format(dateFmt))) {
//						System.out.println(stock.toString());
//						buildJson(stock);
//						stocksArr.add(stock);
					}
////					this.apiRepository.saveAll(stocksArr);
//				}
////				this.apiRepository.saveAll(stocksArr);
//
//				List<Stocks> stocksArr = Arrays.asList(stocks);
//				for(Stocks stock : stocksArr) {
//					System.out.println(stock);
//				}
//			};
////			this.apiRepository.saveAll(stocksArr);
//
//			System.exit(0);
//		};
//		System.exit(0);
//		return null;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//	}

}
	

