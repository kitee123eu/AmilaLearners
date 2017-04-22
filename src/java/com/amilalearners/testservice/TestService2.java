/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import com.amilalearners.model.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Toshiba
 */
@Stateless
public class TestService2 {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public void getAllVehicle() {
        String q = "Select v from Vehicle v";
        Query query = em.createQuery(q);
        List<Vehicle> vehicleList = query.getResultList();
        for(Vehicle v:vehicleList)
        {
            System.out.println(v.getRegistrationNo());
            System.out.println(v.getRegistereddate());
        }
    }

}
