/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.GreaterService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "greaterBacking")
@ViewScoped
public class GreaterBacking {

    @EJB
    GreaterService greaterService;

    public void callingToDisplayMonths() {
        greaterService.getProfitByMonth();
    }

}
