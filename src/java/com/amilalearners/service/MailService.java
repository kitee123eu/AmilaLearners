/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import java.text.MessageFormat;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Toshiba
 */
@Stateless
public class MailService {

    @Resource(name = "mail/gmailAccount")
    private Session mailSession;

    public void sendWelcomeEmail() throws MessagingException {

        String subject = "Register Confirmation";
        String body = " This is a notification e-mail from Amila Learners that you have registered with us.";
               

        String messageText = MessageFormat.format(body, subject);
        mailSession.setDebug(true);
        MimeMessage message = new MimeMessage(mailSession);
        Address toAddress = new InternetAddress("shalinipperera@gmail.com");
        message.setRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject(subject);
        message.setText(messageText);
        message.saveChanges();
        Transport tr = mailSession.getTransport();
        String serverPassword = mailSession.getProperty("mail.password");
        tr.connect(null, serverPassword);
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();

    }

}
