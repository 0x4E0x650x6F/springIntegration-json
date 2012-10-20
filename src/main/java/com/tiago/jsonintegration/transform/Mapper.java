package com.tiago.jsonintegration.transform;

import java.util.Map;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	@Transformer
	public Customer map(Map<String,String> message) {
			
		Customer customer = new Customer();
		customer.setFirstName(message.get("firstName"));
		customer.setLastName(message.get("lastname"));
		customer.setAddress(message.get("address"));
		customer.setCity(message.get("city"));
		customer.setState(message.get("state"));
		customer.setZip(message.get("zip"));

		return customer;
	}
}