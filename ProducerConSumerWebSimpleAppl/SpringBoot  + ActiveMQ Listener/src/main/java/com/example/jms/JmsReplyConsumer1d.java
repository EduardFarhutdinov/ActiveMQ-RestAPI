package com.example.jms;

import com.example.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;


@Component
public class JmsReplyConsumer1d {

	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	private static final Logger logger = Logger.getLogger(JmsReplyConsumer1d.class);

	@JmsListener(destination = "${jsa.activemq.queue.listen}", containerFactory="jsaFactory")
	public void receive(User user) throws JMSException {
//		Message message =jmsTemplate.receive("${jsa.activemq.queue.listen}");
//		messageConverter.fromMessage(message);
		logger.info(user);
	}

//	@JmsListener(destination = "${jsa.activemq.queue.listen}", containerFactory="jsaFactory")
//	public void receive1(User user){
//		System.out.println("Consumer1 "+ user);
//	}
//
//	@JmsListener(destination = "${jsa.activemq.queue.listen}", containerFactory="jsaFactory")
//	public void receive2(User user){
//		System.out.println("Consumer2 "+ user);
//	}
//	@JmsListener(destination = "${jsa.activemq.queue.listen}", containerFactory="jsaFactory")
//	public void receive3(User user){
//		System.out.println("Consumer3 "+ user);
//	}
}
