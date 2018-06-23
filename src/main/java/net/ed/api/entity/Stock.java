package net.ed.api.entity;

import java.math.BigDecimal;

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

@Entity
@Table
public class Stock {
	
	@Column(name="market_date")
	private Date market_date;
	
	@Column(name="open")
	private BigDecimal open;
	
	@Column(name="high")
	private BigDecimal high;
	
	@Column(name="low")
	private BigDecimal low;
	
	@Column(name="close")
	private BigDecimal close;
	
	@Column(name="volume")
	private int volume;
	
	
	
	// constructor
	public Stock(Date market_date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, int volume) {
		this.market_date = market_date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public Stock(Stock theStock) {
		this.market_date = market_date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public Date getMarket_date() {
		return market_date;
	}

	public void setMarket_date(Date market_date) {
		this.market_date = market_date;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
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
		return "Stock [market_date=" + market_date + ", open=" + open + ", high=" + high + ", low=" + low + ", close="
				+ close + ", volume=" + volume + "]";
	}
	
}
