package com.iq.rabbitmq.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iq.rabbitmq.commandline.IqCommandLineComponent;
import com.iq.rabbitmq.constants.IqConstants;
import com.iq.rabbitmq.service.IqMessageSenderService;

@Service
public class IqMessageSenderServiceImpl implements IqMessageSenderService {

	private static final Logger LOGGER = LogManager.getLogger(IqMessageSenderServiceImpl.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${iq.rabbitmq.exchange}")
	private String exchange;

	public IqMessageSenderServiceImpl(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	@Override
	public void send(String msg) {
		LOGGER.info(IqConstants.MESSAGE_PREFIX + msg);
		amqpTemplate.convertAndSend(exchange, "", msg);
	}

}
