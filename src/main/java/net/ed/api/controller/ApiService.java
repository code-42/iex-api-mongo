package net.ed.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	@Autowired
	private ApiRepository apiRepository;

}
