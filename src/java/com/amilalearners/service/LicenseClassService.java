/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import com.amilalearners.model.LicenseClass;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;                                                                                                                                                                                                               
import javax.persistence.PersistenceContext;

/**
 *
 * @author Toshiba
 */
@Stateless
public class LicenseClassService {

    //    inject persisttence unit
    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;
//data base walata data danna udaw wena method

    public LicenseClass addNewLicenseClass(LicenseClass licenseClass) {
//          service wala idan license class wa use karanawa
        em.persist(licenseClass);
        return licenseClass;

    }
}
