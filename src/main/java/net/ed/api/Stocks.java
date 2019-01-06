package net.ed.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
public class Stocks {
	
	// auto-increment primary key
	@Id
	private String _id;
	
	// database fields
	private String symbol;
	private String date;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private int volume;

	// no-arg constructor
	public Stocks() {}
	
	public Stocks(String symbol, String date, Double open, Double high, Double low, Double close,
			int volume) {
//		this._id = _id;
		this.symbol = symbol;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}


	// getters and setters
//	public String getId() {
//		return _id.toHexString();
//	}
//
//	public void set_id(ObjectId _id) { 
//		this._id = _id; 
//	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String market_date) {
		this.date = market_date;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Stocks [id=" + _id + ", symbol=" + symbol + ", date=" + date + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", volume=" + volume + "]";
	}
	
}
