package com.mail_sender.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
     @Autowired
    JavaMailSender javaMailSender;

     public void sendSimpleMail(String toMail , String body , String subject){
         SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

         //how has send to the mail
         simpleMailMessage.setFrom("pasindudenuka703@gmail.com");
         simpleMailMessage.setTo(toMail);
         simpleMailMessage.setText(body);
         simpleMailMessage.setSubject(subject);

         javaMailSender.send(simpleMailMessage);
         System.out.println("Simple massage is sent to mail id " + toMail);
     }
}
