package com.example.demo.controller;

import com.example.demo.EmailCFG;
import com.example.demo.entities.Feedback;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private EmailCFG emailCFG;

    public FeedbackController(EmailCFG emailCFG) {
        this.emailCFG = emailCFG;
    }

    @PostMapping
    public void sendFeedback(@RequestBody Feedback feedback,
                             BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCFG.getHost());
        mailSender.setPort(this.emailCFG.getPort());
        mailSender.setUsername(this.emailCFG.getUsername());
        mailSender.setPassword(this.emailCFG.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("contact@booklender.com");
        mailMessage.setSubject("New feedback from " + feedback.getEname());
        mailMessage.setText(feedback.getFeedback());

        mailSender.send(mailMessage);
    }
}
