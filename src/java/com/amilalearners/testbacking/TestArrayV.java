/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.TestService2;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "testArrayV")
@ViewScoped
public class TestArrayV {

  @EJB
  TestService2 testService2;
  public void callingToDisplayList()
    {
        testService2.getAllVehicle();
    }
    
}
