package com.camel.adi.route;


import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.camel.adi.model.input.Person;

@Component
public class CamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		registerSimpleRoute();
	}
	
	private void registerSimpleRoute() {
		
		Predicate predicate = header("flow").isEqualTo("Adi");
		
		from("direct:getSomething")
				/*
				 * .process(new Processor() {
				 * 
				 * @Override public void process(Exchange exchange) throws Exception { // TODO
				 * Auto-generated method stub exchange.getIn().setBody("Adithiyan"); } })
				 */
		//.doTry()
		.choice().when(predicate)
			.setHeader("name", constant("Adithiyan"))
		.otherwise()
			.setHeader("name", constant("Ezhil"))
		.end()
		
		.setHeader(Exchange.HTTP_METHOD, simple("GET"))
		.setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
		.setHeader("Accept",constant("application/json"))
		.log("name ${header.name}")
		.to("http://localhost:8080/camel/getPerson")
		.unmarshal().json(Person.class)
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Body :"+exchange.getIn().getBody());
				System.out.println("Body Type:"+exchange.getIn().getBody().getClass());
				
				Person person = exchange.getIn().getBody(Person.class);
				
				person.setAge(26);
			}
		})
		.end();
		/*.doCatch(Exception.class)
		.log("${exception.printStackTrace}")
		.end();*/
		
	}

}
