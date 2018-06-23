package net.ed.api.controller;

// many thanks to https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.ed.api.entity.Chart;
import net.ed.api.entity.JsonObject;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONReader {
	
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert JSON string from file to Object
			URL url = new URL("https://api.iextrading.com/1.0/stock/aapl/batch?types=chart&range=1m");
			JsonObject jsonObject = mapper.readValue(url, JsonObject.class);
			printParsedObject(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	   private static void printParsedObject(JsonObject jsonObject) {
			   printCharts(jsonObject.getChart());
	   }
	   
	   private static void printCharts(Chart[] chart) {
		   for(Chart aChart : chart)
			   System.out.println(aChart.getDate() + " " + aChart.getClose());
	   }

}