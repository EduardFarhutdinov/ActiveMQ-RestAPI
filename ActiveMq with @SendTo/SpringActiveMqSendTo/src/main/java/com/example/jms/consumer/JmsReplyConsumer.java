package com.example.jms.consumer;

import com.example.model.Company;
import com.example.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
 
@Component
public class JmsReplyConsumer {


	@JmsListener(destination = "${jsa.activemq.queue.listen", containerFactory="jsaFactory")
	@SendTo("${jsa.activemq.queue.sendto")
	public Message<Product>  receive(Product product, @Header("company") String companyName){
		
		// Console Log
		System.out.println("Recieved Message: " + product);
		
		// set company
		Company apple = new Company("Apple");
		product.setCompany(apple);
		
		Message<Product>  mesage = MessageBuilder
	            .withPayload(product)
	            .setHeader("type", product.getType())
	            .build();
		
		return mesage;	
	}
}
