package com.iq.rabbitmq.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.iq.rabbitmq.constants.IqConstants;


@Component
public class IqMessageListener {

	private static final Logger LOGGER = LogManager.getLogger(IqMessageListener.class);
	
	@RabbitListener(queues="${iq.rabbitmq.queue}")
    public void recievedMessage(String msg) {
		if(!msg.isEmpty()) {
		LOGGER.info(IqConstants.MESSAGE_PREFIX +  msg + IqConstants.MESSAGE_SUFFIX);
		} else{
		LOGGER.info(IqConstants.EMPTY_MESSAGE);
		}
    }
}