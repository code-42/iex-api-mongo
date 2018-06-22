package net.ed.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Stock {
	
	private Date market_date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private int volume;
	
	// constructor
	public Stock(Date market_date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, int volume) {
		super();
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
