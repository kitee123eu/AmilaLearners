/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import static com.amilalearners.model.Profit_.netProfit;
import com.amilalearners.testservice.ProfitService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "profitBacking")
@ViewScoped
public class ProfitBacking {

   
  @EJB
  ProfitService profitService;
  
  
  public void callingToDisplayNetProfit()
    {
        profitService.getProfitByNetProfit();
    }
    
}