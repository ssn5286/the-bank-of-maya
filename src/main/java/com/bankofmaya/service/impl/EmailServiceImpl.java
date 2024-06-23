package com.bankofmaya.service.impl;

import com.bankofmaya.dto.EmailDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailServiceInterface{

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("{$spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetailsDTO emailDetailsDTO) {

        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom(senderEmail);
            email.setTo(emailDetailsDTO.getReceipient());
            email.setSubject(emailDetailsDTO.getSubject());
            email.setText(emailDetailsDTO.getMessageBody());

            javaMailSender.send(email);
            System.out.println("Email sent successfully");
        } catch (MailException e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }
}
