package com.tiago.jsonintegration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiago.jsonintegration.transform.Customer;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MapperTest {

	
	private ApplicationContext appcontext;
	
	@Test
	public void test() {
		
		Assert.assertNotNull(this.appcontext);
	}
	
	@Test
	public void testJson() {
		MessageChannel input = appcontext.getBean("input",MessageChannel.class);
		PollableChannel output = appcontext.getBean("output", PollableChannel.class);
		Customer cust = new Customer();
		cust.setState("state");
		cust.setCity("city");
		cust.setFirstName("fistName");
		cust.setLastName("lastName");
		cust.setZip("zip");
		System.out.println("toString()"+ cust.toString());
		
		Message<Customer> message = MessageBuilder.withPayload(cust).build();
		input.send(message);
		
		Message<?> reply = output.receive();
		System.out.println("recived:"+ reply.getPayload());
		
	}
	
	
	
	@Autowired
    public void setApplicationContext(ApplicationContext applicationContext){
    	this.appcontext = applicationContext;
    }
}
