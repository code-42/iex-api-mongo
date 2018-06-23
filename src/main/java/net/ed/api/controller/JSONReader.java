package net.ed.api.controller;

// many thanks to https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.ed.api.entity.Chart;
import net.ed.api.entity.JsonObject;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONReader {
	
	public static void main(String[] args) {
		
		String date = null;
		BigDecimal open = null;
		BigDecimal high = null;
		BigDecimal low = null;
		BigDecimal close = null;
		BigDecimal volume = null;
		Double unadjustedVolume = null;
		BigDecimal change = null;
		Double changePercent = null;
		BigDecimal vwap = null;
		String label = null;
		Float changeOverTime = null;
		
		Chart chart = new Chart(date, open, high, low, close, volume, unadjustedVolume, change, changePercent, vwap, label, changeOverTime);
		
		List<Chart> theChart = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			// Convert JSON string from file to Object
			URL url = new URL("https://api.iextrading.com/1.0/stock/aapl/batch?types=chart&range=1m");
			JsonObject jsonObject = mapper.readValue(url, JsonObject.class);
			for(Chart aChart : jsonObject.getChart())
				theChart.add(aChart);
		
			for(Chart aChart : theChart)
			System.out.println(aChart);
			   
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}