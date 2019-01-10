package net.ed.api;

import com.mongodb.async.client.MongoDatabase;

public interface IConnect {
	
	public MongoDatabase connectMe();

}
