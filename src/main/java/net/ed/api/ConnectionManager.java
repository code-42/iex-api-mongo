package net.ed.api;

/*
 * Copyright 2019 Edward Dupre 
 */

import org.springframework.stereotype.Component;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Component
public class ConnectionManager implements IConnect {

	// injecting values into fields
	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;
	
	@Value("${mongodb.db}")
	private String defaultDb;
	
	public ConnectionManager() {}

	@Bean
	//  method defined in interface IConnect
	public MongoDatabase connect() {
		
		// client connects to mLab
		MongoClient mongoClient = MongoClients.create(mongoUri);
		
		// get default database
		MongoDatabase database = mongoClient.getDatabase(defaultDb);

		// verify database connection
		if(database != null) {
			System.out.println(database.getName() + " Connected!!");
		} else {
			System.out.println("oops, somethings wrong... check your </>.");
		}
		
		return database;
	}
	

	
}
