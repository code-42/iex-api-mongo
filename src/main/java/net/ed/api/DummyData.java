package net.ed.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

@Component
public class DummyData {
	
	private ApiRepository apiRepository;
	
	public DummyData(ApiRepository apiRepository) {
		this.apiRepository = apiRepository;
	}
	
    public void run(String... strings) throws Exception {
    	
    	// insert dummy data into database
    	Stocks amzn = new Stocks("AMZN", "2019-01-04",1530.0,1594.0,1518.31,1575.39,9182575);
    	buildJson(amzn);
    	
//    	Stocks aapl = new Stocks("AAPL","2019-01-04",144.53,148.5499,143.8,148.26,58607070);
//    	Stocks nflx = new Stocks("NFLX","2019-01-04",281.88,297.8,278.54,297.57,19330102);
////    	List<Stocks> stocksList = Arrays.asList(amzn,aapl,nflx);
//    	System.out.println("Building ArrayList...");
//    	List<Stocks> stocksList = new ArrayList<Stocks>();
//    	stocksList.add(amzn);
//    	stocksList.add(aapl);
//    	stocksList.add(nflx);
    	
//    	for(Stocks stock : stocksList) {
//    		System.out.println(stock.toString());
//    	}
    	
//    	this.apiRepository.saveAll(stocksList);
//    	System.out.println("calling save()...");
//    	apiRepository.saveAll(stocksList);
//    	System.out.println("done save()");
    	
    	System.exit(0);
    }
    
    
    public void buildJson(Stocks stock) {
    	String keys[] = {"symbol","market_date","open","high","low","close","volume"};
    	String values[] = {"AMZN", "2019-01-04","1530.0","1594.0","1518.31","1575.39","9182575"};
    	String stockJson = "{";
    	for (int i = 0; i < keys.length; i++) {
	    	stockJson += "'" + keys[i] + "':'" + values[i] + "'";
	    	if(i < keys.length - 1) { stockJson += ",";}
    	}
    	stockJson += "}";
    	System.out.println(stockJson);
	};
    	
}
