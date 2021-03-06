package com.jms.testing.spring;

import org.springframework.jms.core.JmsTemplate;

public class SpringJmsPersonProducer {

	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final InstructionMessage instructionMessage) {
		getJmsTemplate().convertAndSend(instructionMessage);
	}
}
