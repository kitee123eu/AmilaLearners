/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.admin.backingbean;

import com.amilalearners.service.MailService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.mail.MessagingException;

/**
 *
 * @author Toshiba
 */
@Named(value = "mailBacking")
@ViewScoped
public class MailBacking {

    @EJB
    MailService mailService;
    
    public void test(){
        try {
            mailService.sendWelcomeEmail();
        } catch (MessagingException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
