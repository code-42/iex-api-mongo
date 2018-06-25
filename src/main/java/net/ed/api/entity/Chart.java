package net.ed.api.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonIgnoreProperties({ "chart" })
public class Chart {
	
	private String date;
	private BigDecimal open;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal close;
	private BigDecimal volume;
	private Double unadjustedVolume;
	private BigDecimal change;
	private Double changePercent;
	private BigDecimal vwap;
	private String label;
	private Float changeOverTime;
	
	public Chart() {}

	public Chart(String date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume,
			Double unadjustedVolume, BigDecimal change, Double changePercent, BigDecimal vwap, String label,
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

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public Double getUnadjustedVolume() {
		return unadjustedVolume;
	}

	public void setUnadjustedVolume(Double unadjustedVolume) {
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





