package net.ed.api.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="stocks")
public class Stocks {
	
	// auto-increment primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// database fields
	@Column(name="market_date")
	private Date marketDate;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="open")
	private Double open;
	
	@Column(name="high")
	private Double high;
	
	@Column(name="low")
	private Double low;
	
	@Column(name="close")
	private Double close;
	
	@Column(name="adj_close")
	private Double adjClose;
	
	@Column(name="volume")
	private int volume;
	
//	private List<Equities> todays_equities;
	
	// no-arg constructor
	public Stocks() {
//		System.out.println("47. inside Equities() no-arg constructor");
	}
	
	// equitiess constructor
	public Stocks(Stocks equities) {
		System.out.println("42. inside Totals(List<String> todays_totals) constructor");
		this.marketDate = equities.getMarketDate();
		this.symbol = equities.getSymbol();
		this.open = equities.getOpen();
		this.high = equities.getHigh();
		this.low = equities.getLow();
		this.close = equities.getClose();
		this.adjClose = equities.getAdjClose();
		this.volume = equities.getVolume();		// System.out.println("57. New Totals: " + todaysDate + " " + currentMarketValue + " " + dayGain + " " + totalGain);
	}
	
	// todays_totals constructor
	public Stocks(List<String> todays_equities) throws ParseException {
		System.out.println("42. inside Equities(List<String> todays_equities) constructor");
		this.marketDate = new SimpleDateFormat("yyyy-MM-dd").parse(todays_equities.get(0));
		this.symbol = todays_equities.get(1);
		this.open = Double.parseDouble(todays_equities.get(2));
		this.high = Double.parseDouble(todays_equities.get(3));
		this.low = Double.parseDouble(todays_equities.get(4));
		this.close = Double.parseDouble(todays_equities.get(5));
		this.adjClose = Double.parseDouble(todays_equities.get(6));
		this.volume = Integer.parseInt(todays_equities.get(7));
		// System.out.println(todaysDate + " " + currentMarketValue + " " + dayGain + " " + totalGain);
	}

	public Stocks(int id, Date marketDate, String symbol, Double open, Double high, Double low, Double close, Double adjClose, int volume) {
		this.id = id;
		this.marketDate = marketDate;
		this.symbol = symbol;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjClose = adjClose;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public Date getMarketDate() {
		return marketDate;
	}

	public void setMarketDate(Date marketDate) {
		this.marketDate = marketDate;
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

	public Double getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(Double adjClose) {
		this.adjClose = adjClose;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Equities [id=" + id + ", marketDate=" + marketDate + ", symbol=" + symbol + ", open=" + open + ", high="
				+ high + ", low=" + low + ", close=" + close + ", adjClose=" + adjClose + ", volume=" + volume + "]";
	}
	
}
