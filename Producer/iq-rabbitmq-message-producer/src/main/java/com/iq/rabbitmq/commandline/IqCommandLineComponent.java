package com.iq.rabbitmq.commandline;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iq.rabbitmq.service.IqMessageSenderService;

@Component
public class IqCommandLineComponent implements CommandLineRunner{

	private static final Logger LOGGER = LogManager.getLogger(IqCommandLineComponent.class);

	@Autowired
	private IqMessageSenderService iQMessageSenderService;

	@Override
	public void run(String... args) throws Exception {
		String inputMessage = Arrays.stream(args).collect(Collectors.joining(","));
		LOGGER.info("--------------------------------------->   " +inputMessage);
		iQMessageSenderService.send(inputMessage);
	}

}
