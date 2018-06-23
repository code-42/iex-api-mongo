package net.ed.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)
@JsonIgnoreProperties({ "chart" })
public class Chart {
	
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
	private String unadjustedVolume;
	private String change;
	private String changePercent;
	private String vwap;
	private String label;
	private String changeOverTime;
	
	public Chart() {}
	
	public Chart(String date, String open, String high, String low, String close, String volume,
			String unadjustedVolume, String change, String changePercent, String vwap, String label,
			String changeOverTime) {
		super();
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getUnadjustedVolume() {
		return unadjustedVolume;
	}

	public void setUnadjustedVolume(String unadjustedVolume) {
		this.unadjustedVolume = unadjustedVolume;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(String changePercent) {
		this.changePercent = changePercent;
	}

	public String getVwap() {
		return vwap;
	}

	public void setVwap(String vwap) {
		this.vwap = vwap;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getChangeOverTime() {
		return changeOverTime;
	}

	public void setChangeOverTime(String changeOverTime) {
		this.changeOverTime = changeOverTime;
	}

	@Override
	public String toString() {
		return "[date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
				+ ", volume=" + volume + ", unadjustedVolume=" + unadjustedVolume + ", change=" + change
				+ ", changePercent=" + changePercent + ", vwap=" + vwap + ", label=" + label + ", changeOverTime="
				+ changeOverTime + "]";
	}
	
//	private Date date;
//	private BigDecimal open;
//	private BigDecimal high;
//	private BigDecimal low;
//	private BigDecimal close;
//	private BigDecimal volume;
//	private Double unadjustedVolume;
//	private BigDecimal change;
//	private Double changePercent;
//	private BigDecimal vwap;
//	private String label;
//	private Float changeOverTime;



	
}





