/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.TestServiceCal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "testBackingCal")
@ViewScoped
public class TestBackingCal {

    @EJB
    TestServiceCal testServiceCal;

    public void callingToCal()
            
     {
        testServiceCal.cal();
    }
}
