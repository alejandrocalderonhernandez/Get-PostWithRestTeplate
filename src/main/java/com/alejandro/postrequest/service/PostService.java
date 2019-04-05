package com.alejandro.postrequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {
	
	@Autowired
	RestTemplate restTemplate;
	
	final String URI = "https://accounts.spotify.com/api/token";
	HttpHeaders headers = new HttpHeaders();
	
	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
	
	public ResponseEntity<String>  getPOST() {
		
		this.headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		this.map.add("grant_type", "client_credentials");
		this.map.add("client_id", "ebcf439a2ab846e89117539d71c9f1b8");
		this.map.add("client_secret", "bbda79615f6a4ec595a242b4479d4d24");
		
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<String> response = restTemplate.exchange( this.URI, HttpMethod.POST, request , String.class );	
		
		return response;
	}
	
	
	
	

}
