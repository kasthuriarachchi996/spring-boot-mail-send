package com.mail_sender.demo.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;


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


     public void sendMailWithAttachment(String toMail ,
                                        String body ,
                                        String subject ,
                                        String attachment) throws MessagingException {

         MimeMessage mimeMessage = javaMailSender.createMimeMessage();
         MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
         mimeMessageHelper.setFrom("pasindudenuka703@gmail.com");
         mimeMessageHelper.setTo(toMail);
         mimeMessageHelper.setText(body);
         mimeMessageHelper.setSubject(subject);

         FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));

         mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()),fileSystemResource);
         javaMailSender.send(mimeMessage);
         System.out.println("Mail send with attachment with mail address " + toMail);
     }

}
