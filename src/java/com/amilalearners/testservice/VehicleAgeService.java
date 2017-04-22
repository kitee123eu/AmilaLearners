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
public class VehicleAgeService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

//    public void getVehicleByAge(int age)
//    {
//        String q="select v from Vehicle v where v.age=:age";
//        Query query=em.createQuery(q);
//        query.setParameter("age",age);
//        List<Vehicle> vehicleList = query.getResultList();
//        for(Vehicle v:vehicleList)
//            
//            
////        {
////            System.out.println(v.getRegistrationNo());
////        }
////        
//        
    public void editVehicleByAge(int age) {
        String q = "select v from Vehicle v where v.age=:age";
        Query query = em.createQuery(q);
        query.setParameter("age", age);
        List<Vehicle> vehicleList = query.getResultList();
        for (Vehicle v : vehicleList) {
            v.setAge(30);
        }
    }
}
