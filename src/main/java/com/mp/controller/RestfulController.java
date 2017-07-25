package com.mp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mp.database.message.Message;
import com.mp.database.message.MessageRepo;

@RestController
public class RestfulController {
	
	@Autowired
	private MessageRepo messageRepo;
	
	@RequestMapping("/user")
	public String user(Principal principal) {
		return principal.getName();
	}
	
	@GetMapping(value="/messages_test")
	public String messages() {
		List<Message> allMessages = messageRepo.findAll();
		StringBuilder returner = new StringBuilder();
		for(Message msg : allMessages) {
			returner.append(msg.getContent());
			returner.append(" ");
		}
		return returner.toString();
	}
}
