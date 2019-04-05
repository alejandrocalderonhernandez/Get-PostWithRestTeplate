package com.alejandro.postrequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetService {
	

	@Autowired
	RestTemplate restTemplate;
	
	final String URI = "https://restcountries.eu/rest/v2/region/";
	StringBuilder sb;
	
	 public String  getGET(final String region) {
		 
		sb	 =  new StringBuilder();
		String url = sb.append(URI).append(region).toString();
		System.out.println(url);
		String response = restTemplate.getForObject(url, String.class);
	
		return response;

	}
	
	

}
