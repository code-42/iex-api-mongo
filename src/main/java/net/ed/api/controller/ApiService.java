package net.ed.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ed.api.entity.Chart;

@Service
public class ApiService {
	
	@Autowired
	private ApiRepository apiRepository;
	
	public void addChart(Chart chart) {
		apiRepository.save(chart);
	}

}
