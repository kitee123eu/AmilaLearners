/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.TestService1Cal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "testCal")
@ViewScoped
public class TestCal {
    
@EJB
TestService1Cal testService1Cal;

public void marks(){

   int marks []={90,60,70,50};
    System.out.println(testService1Cal.callTo(marks));

 }
}
   
    
    

