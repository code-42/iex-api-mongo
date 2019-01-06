package net.ed.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.ed.api.Stocks;

@EnableScheduling
@SpringBootApplication
@RestController
public class ApiController implements CommandLineRunner {
	
//	@Autowired
	private ApiRepository apiRepository;
	
	String[] symbols = {"AAPL","INTC","AMZN","AMD","NFLX","MU","BABA","FB","BAC","MSFT"};
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		
		System.out.println("Helllllooooo");

		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("61. yesterday == " + yesterday.format(dateFmt));
		
		return args -> {
			for(String symbol : symbols) {
				System.out.println(symbol);
				Stocks[] stocks = restTemplate.getForObject(
					"https://api.iextrading.com/1.0/stock/" + symbol + "/chart", Stocks[].class);

				for(Stocks stock : stocks) {
					stock.setSymbol(symbol);
					
//					if(stock.getDate().equals("2018-12-27")) {
					if(stock.getDate().equals(yesterday.format(dateFmt))) {
						System.out.println(stock.toString());
//						apiRepository.save(stock);
					}
				}
			}
			System.exit(0);
		};
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
}
	

