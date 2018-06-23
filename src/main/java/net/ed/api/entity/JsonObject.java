package net.ed.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({ "chart" })
public class JsonObject {
	
	private Chart[] chart;
	
	public JsonObject() {}

	public Chart[] getChart() {
		return chart;
	}

	public void setCharts(Chart[] chart) {
		this.chart = chart;
	}
}
