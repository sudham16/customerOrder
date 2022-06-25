package com.camel.adi.controller;

import com.camel.adi.mapper.OrderMapper;
import com.camel.adi.model.output.CustomerOrder;
import com.camel.adi.rules.CustomerOrderDroolService;
import com.camel.adi.rules.CustomerOrderDrools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

	private final OrderMapper orderMapper;

	private final CustomerOrderDroolService customerOrderDroolService;

	@Autowired
	public NameController(OrderMapper orderMapper, CustomerOrderDroolService customerOrderDroolService) {
		this.orderMapper = orderMapper;
		this.customerOrderDroolService = customerOrderDroolService;
	}


	@GetMapping(path = "/getPerson", produces = MediaType.APPLICATION_JSON_VALUE)
	private Person getPerson (@RequestHeader("name") String name) {
		return new Person(name, 28);
	}
	
	@PostMapping(path = "/getPerson", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
	private CustomerOrder getOrder (@RequestBody String value) {
		//ApplicationContext context = new AnnotationConfigApplicationContext(CustomerOrderDrools.class);
		//CustomerOrderDroolService customerOrderDroolService = context.getBean(CustomerOrderDroolService.class);
		OrderInfo orderInfo = Test.getOrderInfo( value);
		CustomerOrder customerOrder = orderMapper.toCustomerOrder(orderInfo);
		customerOrderDroolService.calculateAmountAndDiscount(customerOrder);
		return customerOrder;
	}

}
