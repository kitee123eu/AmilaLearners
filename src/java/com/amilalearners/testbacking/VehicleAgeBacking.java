/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.VehicleAgeService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "vehicleAgeBacking")
@ViewScoped
public class VehicleAgeBacking {

  @EJB
  VehicleAgeService vehicleAgeService;
  public void callingToDisplayAge()
    {
//         vehicleAgeService.getVehicleByAge(10);
         vehicleAgeService.editVehicleByAge(24);
    
}
}
