package com.alejandro.postrequest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.postrequest.service.GetService;
import com.alejandro.postrequest.service.PostService;

@RestController(value = "/api")
public class Controller {
	
    @Autowired
	PostService postService;
	@Autowired
	GetService getService;

		  @RequestMapping(value = "/post", method = RequestMethod.GET)
		  public ResponseEntity<String>  getPOST() {
			  return postService.getPOST();
		  }
		  
		  @RequestMapping(value = "/get", method = RequestMethod.GET)
		  public String getGET(@RequestParam String region) {
			  return getService.getGET(region);
		  }
}
