package net.ed.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import net.ed.api.Stocks;

@Repository
public interface ApiRepository extends MongoRepository<Stocks, String> {
	
//	public Stocks findBySymbol(String symbol);
	

}
