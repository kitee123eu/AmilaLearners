/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.admin.backingbean;

import com.amilalearners.model.LicenseClass;
import com.amilalearners.service.LicenseClassService;
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
@Named(value = "licenseClassAddBacking")
@ViewScoped
public class LicenseClassAddBacking {
//inject LicenseClassService object

    @EJB
    LicenseClassService licenseClassService;
    //   LicenseClassService gen "LicenseClassService" lesa refference ekak hadala thiyenne
    @Named
    @Produces
    @RequestScoped
    LicenseClass licenseClass = new LicenseClass();

    public LicenseClassService getLicenseClassService() {
        return licenseClassService;
    }

    public void setLicenseClassService(LicenseClassService licenseClassService) {
        this.licenseClassService = licenseClassService;
    }

    public LicenseClass getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(LicenseClass licenseClass) {
        this.licenseClass = licenseClass;
    }

    public String createLicenseClass() {
        licenseClass = licenseClassService.addNewLicenseClass(licenseClass);
//        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(licenseClass.getClass() + " Saved Successfully"));
        clear();
        return null;

    }

    public void clear() {
        licenseClass.setClass1("");
        licenseClass.setClassDescription("");
        licenseClass.setTotalFee(0);
        licenseClass.setBasicFee(0);
        
    }

}