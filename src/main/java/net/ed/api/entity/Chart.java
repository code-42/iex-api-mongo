package net.ed.api.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@JsonIgnoreProperties(ignoreUnknown=true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="chart")
public class Chart implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

	@Column(name="market_date")
	private Date date;
	
	@Column(name="open_price")
	private Double open;
	
	@Column(name="high_price")
	private Double high;
	
	@Column(name="low_price")
	private Double low;
	
	@Column(name="close_price")
	private Double close;
	
	@Column(name="volume")
	private int volume;
	
	@Column(name="unadjusted_volume")
	private int unadjustedVolume;
	
	@Column(name="change_price")
	private Double change;
	
	@Column(name="change_percent")
	private Double changePercent;
	
	@Column(name="vwap")
	private Double vwap;
	
	@Column(name="label")
	private String label;
	
	@Column(name="change_over_time")
	private Double changeOverTime;
	
	public Chart() {}

	@JsonProperty("date")
	public Date getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(Date market_date) {
		this.date = market_date;
	}

	@JsonProperty("open")
	public Double getOpen() {
		return open;
	}

	@JsonProperty("open")
	public void setOpen(Double open) {
		this.open = open;
	}

	@JsonProperty("high")
	public Double getHigh() {
		return high;
	}

	@JsonProperty("high")
	public void setHigh(Double high) {
		this.high = high;
	}

	@JsonProperty("low")	
	public Double getLow() {
		return low;
	}

	@JsonProperty("low")
	public void setLow(Double low) {
		this.low = low;
	}

	@JsonProperty("close")
	public Double getClose() {
		return close;
	}

	@JsonProperty("close")
	public void setClose(Double close) {
		this.close = close;
	}

	@JsonProperty("volume")
	public int getVolume() {
		return volume;
	}

	@JsonProperty("volume")
	public void setVolume(int volume) {
		this.volume = volume;
	}

	@JsonProperty("unadjustedVolume")
	public int getUnadjustedVolume() {
		return unadjustedVolume;
	}

	@JsonProperty("unadjustedVolume")
	public void setUnadjustedVolume(int unadjustedVolume) {
		this.unadjustedVolume = unadjustedVolume;
	}

	@JsonProperty("change")
	public Double getChange() {
		return change;
	}

	@JsonProperty("change")
	public void setChange(Double change) {
		this.change = change;
	}

	@JsonProperty("changePercent")
	public Double getChangePercent() {
		return changePercent;
	}

	@JsonProperty("changePercent")
	public void setChangePercent(Double changePercent) {
		this.changePercent = changePercent;
	}

	@JsonProperty("vwap")
	public Double getVwap() {
		return vwap;
	}

	@JsonProperty("vwap")
	public void setVwap(Double vwap) {
		this.vwap = vwap;
	}

	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	@JsonProperty("label")
	public void setLabel(String label) {
		this.label = label;
	}

	@JsonProperty("changeOverTime")
	public Double getChangeOverTime() {
		return changeOverTime;
	}

	@JsonProperty("changeOverTime")
	public void setChangeOverTime(Double changeOverTime) {
		this.changeOverTime = changeOverTime;
	}

	@Override
	public String toString() {
		return "Chart [date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close="
				+ close + ", volume=" + volume + ", unadjustedVolume=" + unadjustedVolume + ", change=" + change
				+ ", changePercent=" + changePercent + ", vwap=" + vwap + ", label=" + label + ", changeOverTime="
				+ changeOverTime + "]";
	}
}





