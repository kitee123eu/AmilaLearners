/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.admin.backingbean;

import com.amilalearners.model.Trainee;
import com.amilalearners.service.TraineeService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "traineeAddBacking")
@ViewScoped
public class TraineeAddBacking {

    @EJB
    TraineeService traineeService;
    
    @Named
    @Produces
    @RequestScoped
    Trainee trainee = new Trainee();

    public TraineeService getTraineeService() {
        return traineeService;
    }

    public void setTraineeService(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    

     public String createTrainee() {
        trainee = traineeService.addNewTrainee(trainee);
//        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(trainee.getClass() + " Saved Successfully"));
        clear();
        return null;

    }

    public void clear() {
        trainee.setNameWithInitials("");
        trainee.setFullName("");
        trainee.setDateOfBirth(null);
        trainee.setGender(null);
        trainee.setCivilStatus("");
        trainee.setNicNo("");
        
        
    }
    
}
    
    
   

