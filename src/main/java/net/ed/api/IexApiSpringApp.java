package net.ed.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.ed.api.controller.ApiController;

@SpringBootApplication
public class IexApiSpringApp {

	public static void main(String[] args) {
		SpringApplication.run(IexApiSpringApp.class, args);
		
		ApiController.main(args);
	}
}
