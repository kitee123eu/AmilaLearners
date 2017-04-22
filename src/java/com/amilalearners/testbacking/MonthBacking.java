/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.MonthService;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "monthBacking")
@ViewScoped
public class MonthBacking {

      
  @EJB
  MonthService monthService;
  
  
  public void callingToDisplayMonth()
    {
        monthService.getProfitByMonth();
    }
    
}
