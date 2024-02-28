package com.mail_sender.demo;

import com.mail_sender.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringbootMailSendApplication {

	@Autowired
	HomeService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMailSendApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){

		service.sendSimpleMail("kamalnimal2255@gmail.com",
				"this is test body from pasindu denuka",
				"pasindu denuka");
	}

}
