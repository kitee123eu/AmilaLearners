/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.TestServiceArray;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "testArray")
@ViewScoped
public class TestArray {

    @EJB
    TestServiceArray testServiceArray;
    
    public void marks()
    {
        int[] marks={90,60,75,40};
        testServiceArray.callTo(marks);
       
        
    }
    
}
