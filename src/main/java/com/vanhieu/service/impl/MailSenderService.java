package com.vanhieu.service.impl;

import com.vanhieu.service.IMailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService implements IMailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toEmail, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vanhieuit10@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        System.out.println("mail send successfully...");
    }


}
