/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import com.amilalearners.model.Vehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Toshiba
 */
@Stateless
public class VehicleServiceEdit {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public void editVehicle(int id)
    {
        Vehicle vehicle=em.find(Vehicle.class,id);
        vehicle.setRegistrationNo("10002");
    }
}
