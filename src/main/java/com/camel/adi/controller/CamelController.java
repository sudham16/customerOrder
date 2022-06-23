package com.camel.adi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camel.adi.service.CamelService;

@RestController
public class CamelController {
	
	@Autowired
	private CamelService service;
	
	@GetMapping(path = "/getSomething", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getSomething (@RequestParam("flow") String flow) {
		System.out.println("inside CamelController~getSomething()");
		return service.getSomething(flow);
		
	}

}
