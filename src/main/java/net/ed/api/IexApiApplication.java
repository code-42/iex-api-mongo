package net.ed.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class IexApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IexApiApplication.class, args);
	}

}
