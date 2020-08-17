package com.iq.rabbitmq.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import com.iq.rabbitmq.service.impl.IqMessageSenderServiceImpl;

@SpringBootTest
public class IqMessageSenderServiceTest {
	
	IqMessageSenderServiceImpl iqMessageSenderServiceImpl;
	AmqpTemplate amqpTemplate;
	
	@Before
	public void setup() {
		this.amqpTemplate = Mockito.mock(AmqpTemplate.class);
	    this.iqMessageSenderServiceImpl = new IqMessageSenderServiceImpl(this.amqpTemplate);
	}
	
	@Test
	void testSend() {
		assertThatCode(() -> this.iqMessageSenderServiceImpl.send("Test")).doesNotThrowAnyException();
		 Mockito.verify(this.amqpTemplate)
	        .convertAndSend(eq(""), eq(""), eq("Test"));
	}

}
