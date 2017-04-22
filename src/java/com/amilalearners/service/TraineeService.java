/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import com.amilalearners.model.Trainee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Toshiba
 */
@Stateless
public class TraineeService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;
    
    public Trainee addNewTrainee(Trainee trainee) {
        em.persist(trainee);
        return trainee;
        
}
}
