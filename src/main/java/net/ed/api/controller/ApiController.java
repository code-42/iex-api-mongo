package net.ed.api.controller;

// many thanks to https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.ed.api.entity.Chart;

//@JsonIgnoreProperties(ignoreUnknown = true)
@RestController
public class ApiController {
	
	@Autowired
	private static ApiService apiService;
	
	@RequestMapping(method=RequestMethod.POST, value="/charts")
	public String addChart(@RequestBody Chart chart) {
		apiService.addChart(chart);
		String response = "{\"success\": true, \"message\": Chart has been added successfully.}";
		return response;
	}
	
	@RequestMapping("/getAllCharts")
	public List<Chart> getAllTopics() {
		return apiService.getAllCharts();
	}
	
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
//		System.out.println(ObjMap());
		ObjMap();
//		GsonDeserializer();
//		JsonToJava();
		
	}
		
	public static void JsonToJava() throws IOException {
			
		String url = "https://api.iextrading.com/1.0/stock/amzn/chart";

		try(Reader reader = new InputStreamReader(ApiController.class.getResourceAsStream(url), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            Chart[] c = gson.fromJson(reader, Chart[].class);
            System.out.println(c);
        }
	}
	
	public static void GsonDeserializer() throws IOException {
		
		Gson gson = new Gson();
		
		try {
//			URL url = new URL("https://api.iextrading.com/1.0/stock/amzn/batch?types=chart");
			String url = "https://api.iextrading.com/1.0/stock/amzn/chart";
			
			Chart[] charts = gson.fromJson(url, Chart[].class);
			System.out.println("46. it's working!!! ");
		
			for(Chart aChart : charts) {
				System.out.println(aChart);
//				apiService.addChart(aChart);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void ObjMap() {
		
//		String date = null;
//		BigDecimal open = null;
//		BigDecimal high = null;
//		BigDecimal low = null;
//		BigDecimal close = null;
//		int volume = 0;
//		int unadjustedVolume = 0;
//		BigDecimal change = null;
//		Double changePercent = null;
//		BigDecimal vwap = null;
//		String label = null;
//		Float changeOverTime = null;
		
//		Chart chart = new Chart(date, open, high, low, close, volume, unadjustedVolume, change, changePercent, vwap, label, changeOverTime);
//		MyPojo myPojo = new MyPojo(chart);
//		
		List<Chart> theChart = new ArrayList<>();
//		List<String> eChart = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			// Convert JSON string from file to Object
			URL url = new URL("https://api.iextrading.com/1.0/stock/fb/chart");
//			String url = "https://api.iextrading.com/1.0/stock/amzn/chart";
			Chart[] charts = mapper.readValue(url, Chart[].class);
			
			System.out.println("56. it's working!!! " + charts[0].toString());
//			apiService.addChart(charts[0]);
			
			for(int i = 0; i < charts.length; i++) {
				theChart.add(new Chart(charts[i]));
			}
			
			for(Chart aChart : theChart)
				System.out.println("116. " + aChart);
			
//			for(Chart aChart : charts) {
//				System.out.println(aChart);
////				theChart.add(new Chart(charts[0]));
////				apiService.addChart(chart[0]);
//			}
			
			for(int i = 0; i < charts.length; i++) {
//				theChart.add(new Chart(charts[i]));
				apiService.addChart(new Chart(charts[i]));
			}
			//
			
//			for(Chart aChart : jsonObject) {
//				System.out.println(aChart);
//				apiService.addChart(aChart);
//			}
			
			
//			for(Chart aChart : theChart) {
//				System.out.println("59. " + aChart.getDate());
//				cChart.addAll(theChart);
//				System.out.println("61. " + cChart);
//			}
			// apiService.addChart(aChart);
			   
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}