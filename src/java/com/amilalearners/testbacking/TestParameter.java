/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.TestServicePara;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "testParameter")
@ViewScoped
public class TestParameter {
@EJB
TestServicePara testServicePara;

   public void passData()
   {
      testServicePara.displayParameter(90, 50);
       
   }
           
  
}

