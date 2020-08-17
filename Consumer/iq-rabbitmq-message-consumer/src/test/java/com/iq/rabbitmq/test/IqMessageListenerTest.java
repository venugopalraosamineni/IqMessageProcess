package com.iq.rabbitmq.test;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iq.rabbitmq.listener.IqMessageListener;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IqMessageListenerTest {

	private IqMessageListener iqMessageListener;

	@Before
	public void setup() {
		iqMessageListener = new IqMessageListener();
	}
	
	@Test
	public void recievedMessageTest() {
		iqMessageListener.recievedMessage("test");
	}
}
