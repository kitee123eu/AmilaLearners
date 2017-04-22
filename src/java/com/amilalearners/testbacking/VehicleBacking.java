/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.service.VehicleService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "vehicleBacking")
@ViewScoped
public class VehicleBacking {

  @EJB
  VehicleService vehicleService;
  public void callingToDisplayList()
    {
         vehicleService.getVehicleById(1);
         vehicleService.getVehicleById(3);
         
    }
    
}
