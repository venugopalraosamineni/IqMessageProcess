package com.iq.rabbitmq.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iq.rabbitmq.constants.IqConstants;
import com.iq.rabbitmq.service.IqMessageSenderService;

@RestController
@RequestMapping(value = "/iq-rabbitmq/")
public class IqMessageController {
	@Autowired
	private IqMessageSenderService iQMessageSenderService;
	

	@GetMapping(value = "/send")
	public String sendMessage(@RequestParam("message") String message) {
		iQMessageSenderService.send(message);
		return IqConstants.SUCCESS_MESSAGE;
	}
	
}
