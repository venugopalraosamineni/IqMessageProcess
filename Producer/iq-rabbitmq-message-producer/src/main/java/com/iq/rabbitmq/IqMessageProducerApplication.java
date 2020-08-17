package com.iq.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iq.rabbitmq.service.impl.IqMessageSenderServiceImpl;

@SpringBootApplication
public class IqMessageProducerApplication {
//implements ApplicationRunner {

	/*
	 * @Autowired private IQMessageSenderServiceImpl IQMessageSenderService;
	 * 
	 * 
	 * @Value("${iq.message}") private String message;
	 */

	public static void main(String[] args) {
		SpringApplication.run(IqMessageProducerApplication.class, args);
	}
	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * IQMessageSenderService.send(message); }
	 */
}
