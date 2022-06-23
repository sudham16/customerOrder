package com.camel.adi.service;

import org.apache.camel.FluentProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamelService {

	@Autowired
	private FluentProducerTemplate fluentProducerTemplate;

	public Object getSomething(String flow) {
		System.out.println("inside CamelService~getSomething()");

		return fluentProducerTemplate.clearAll().withHeader("flow", flow).to("direct:getSomething").request();
	}

}
