package net.ed.api.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
//@JsonIgnoreProperties({ "chart" })
@Entity
public class Chart {
	
	@Id
	private String date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private int volume;
	private int unadjustedVolume;
	private BigDecimal change;
	private Double changePercent;
	private BigDecimal vwap;
	private String label;
	private Float changeOverTime;
	
	public Chart() {}

	public Chart(String date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, int volume,
			int unadjustedVolume, BigDecimal change, Double changePercent, BigDecimal vwap, String label,
			Float changeOverTime) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.unadjustedVolume = unadjustedVolume;
		this.change = change;
		this.changePercent = changePercent;
		this.vwap = vwap;
		this.label = label;
		this.changeOverTime = changeOverTime;
	}

	public Chart(Chart theChart) {
		// TODO Auto-generated constructor stub
		this.date = theChart.getDate();
		this.open = theChart.getOpen();
		this.high = theChart.getHigh();
		this.low = theChart.getLow();
		this.close = theChart.getClose();
		this.volume = theChart.getVolume();
		this.unadjustedVolume = theChart.getUnadjustedVolume();
		this.change = theChart.getChange();
		this.changePercent = theChart.getChangePercent();
		this.vwap = theChart.getVwap();
		this.label = theChart.getLabel();
		this.changeOverTime = theChart.getChangeOverTime();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getUnadjustedVolume() {
		return unadjustedVolume;
	}

	public void setUnadjustedVolume(int unadjustedVolume) {
		this.unadjustedVolume = unadjustedVolume;
	}

	public BigDecimal getChange() {
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	public Double getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(Double changePercent) {
		this.changePercent = changePercent;
	}

	public BigDecimal getVwap() {
		return vwap;
	}

	public void setVwap(BigDecimal vwap) {
		this.vwap = vwap;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Float getChangeOverTime() {
		return changeOverTime;
	}

	public void setChangeOverTime(Float changeOverTime) {
		this.changeOverTime = changeOverTime;
	}

	@Override
	public String toString() {
		return "Chart [date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
				+ ", volume=" + volume + ", unadjustedVolume=" + unadjustedVolume + ", change=" + change
				+ ", changePercent=" + changePercent + ", vwap=" + vwap + ", label=" + label + ", changeOverTime="
				+ changeOverTime + "]";
	}

	

}





