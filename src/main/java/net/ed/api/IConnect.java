package net.ed.api;

/*
 * Copyright 2019 Edward Dupre 
 */

import com.mongodb.async.client.MongoDatabase;

public interface IConnect {
	
	// implemented in ConnectionManager
	public MongoDatabase connect();

}
