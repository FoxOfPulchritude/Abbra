package com.mp;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "redirect:index.html";
	}
	
	//the logon mapping
	@RequestMapping(value = "/logon", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String pw) {
		final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
		if(!username.equals("admin")) {
			return "redirect:error";
		}else if(!pw.equals("mpotocki")) {
			return"redirect:error";
		}else
			logger.warn("User login was a success.");
			return "redirect:/index.html";
			
	}
}
