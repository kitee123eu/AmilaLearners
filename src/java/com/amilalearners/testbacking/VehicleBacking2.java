/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.model.Vehicle;
import com.amilalearners.testservice.VehicleService2;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "vehicleBacking2")
@ViewScoped
public class VehicleBacking2 {

    @EJB
    VehicleService2 vehicleService2;

    public void callToGetVehicleById() {

        Vehicle vehicle = vehicleService2.getVehicleById(3);
        

        {
            System.out.println(vehicle.getRegistrationNo());

        }

    }
}
