package com.ubednama.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

public interface EmailService {
    void sendEmailWithToken(String userEmail, String link) throws MessagingException;
}
