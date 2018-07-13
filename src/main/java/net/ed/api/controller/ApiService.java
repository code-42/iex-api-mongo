package net.ed.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ed.api.entity.Chart;

@Service
public class ApiService {
	
	@Autowired
	private ApiRepository apiRepository;
	
	public void addChart(Chart chart) {
		System.out.println("17. " + chart.toString());
		this.apiRepository.save(chart);
	}
	
	public List<Chart> getAllCharts() {
		return (List<Chart>) this.apiRepository.findAll();
	}

//	public void addChart(List<String> theChart) {
//		System.out.println("22. " + theChart.toString());
//		apiRepository.save(theChart);		
//	}

}
