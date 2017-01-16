package com.jms.testing.spring;

import java.net.URISyntaxException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsMessageConverterExample {
	public static void main(String[] args) throws URISyntaxException, Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"appContextWithMessageConverter.xml");

		try {
			SpringJmsPersonProducer springJmsProducer = (SpringJmsPersonProducer) context.getBean("springJmsPersonProducer");
			InstructionMessage m1 = new InstructionMessage(10,10,10,10,10);
			System.out.println("Sending person " + m1);
			springJmsProducer.sendMessage(m1);
			
			InstructionMessage m2 = new InstructionMessage(5,5,5,5,5);
			System.out.println("Sending person " + m2);
			springJmsProducer.sendMessage(m2);
			
			InstructionMessage m3 = new InstructionMessage(0,0,0,0,0);
			System.out.println("Sending person " + m3);
			springJmsProducer.sendMessage(m3);

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			SpringJmsPersonConsumer springJmsConsumer = (SpringJmsPersonConsumer) context.getBean("springJmsPersonConsumer");
			System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
		} finally {
			context.close();
		}
	}
}
