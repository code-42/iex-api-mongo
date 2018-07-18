package net.ed.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class IexApiApplication {

	// @Scheduled(cron = "0 47 17 * * MON,TUE,WED,THU,FRI")
	// Encountered invalid @Scheduled method 'main': Only no-arg methods may be annotated with @Scheduled
	public static void main(String[] args) {
//		SpringApplication.run(IexApiApplication.class, args);
		runApp();
	}

	@Scheduled(cron = "* 19 9 * * ?")
//	@Scheduled(fixedDelay=10000)
	public static void runApp() {
		SpringApplication.run(IexApiApplication.class);
	}
	
}
