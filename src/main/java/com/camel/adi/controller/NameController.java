package com.camel.adi.controller;

import com.camel.adi.mapper.OrderMapper;
import com.camel.adi.model.output.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.camel.adi.Test;
import com.camel.adi.model.input.OrderInfo;
import com.camel.adi.model.input.Person;

@RestController
public class NameController {

	@Autowired
	private OrderMapper orderMapper;

	@GetMapping(path = "/getPerson", produces = MediaType.APPLICATION_JSON_VALUE)
	private Person getPerson (@RequestHeader("name") String name) {
		return new Person(name, 28);
	}
	
	@PostMapping(path = "/getPerson", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
	private CustomerOrder getOrder (@RequestBody String value) {

		OrderInfo orderInfo = Test.getOrderInfo( value);
		// Cnvert orderInfo to output object
		// output obj to Drools
		//return output Object
		return orderMapper.toCustomerOrder(orderInfo);

	}

}
