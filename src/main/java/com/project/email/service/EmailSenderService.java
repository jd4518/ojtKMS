package com.project.email.service;

import javax.mail.MessagingException;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.project.category.dao.CategoryDao;
import com.project.email.model.Email;

@Component
public class EmailSenderService {
	private static final Logger logger = LoggerFactory.getLogger(EmailSenderService.class);
	
	  @Autowired
      protected JavaMailSender  mailSender;
      public void SendEmail(Email email) throws Exception {
           
          MimeMessage msg = mailSender.createMimeMessage();
          try {
              msg.setSubject(email.getSubject());
              msg.setText(email.getContent());
              msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email.getReceiver()));
             
          }catch(MessagingException e) {
              logger.debug("MessagingException");
              e.printStackTrace();
          }
          try {
              mailSender.send(msg);
          }catch(MailException e) {
        	  logger.debug("MessagingException");
              e.printStackTrace();
          }
      }
}
