package com.vanhieu.service;

import org.springframework.stereotype.Service;

@Service
public interface IMailSenderService {
    void sendEmail(String toEmail, String subject, String body);
}
