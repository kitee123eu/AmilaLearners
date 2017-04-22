/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import com.amilalearners.model.Vehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Toshiba
 */
@Stateless
public class VehicleService {

  
    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public void getVehicleById(int id)
    {
        Vehicle vehicle=em.find(Vehicle.class,id);
        System.out.println(vehicle.getRegistrationNo());
    }
}
