package net.ed.api.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="stocks")
public class Stocks implements Serializable {
	
	// auto-increment primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symbol")
	private String symbol;
	
	// database fields
	@Column(name="market_date")
	private String date;
	
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
	
	// no-arg constructor
	public Stocks() {}
	
	// getters and setters
	public int getId() {
		return id;
	}

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
		return "Stocks [symbol=" + symbol + ", date=" + date + ",  open=" + open + ", high="
				+ high + ", low=" + low + ", close=" + close + ", adjClose=" + adjClose + ", volume=" + volume + "]";
	}
	
}
