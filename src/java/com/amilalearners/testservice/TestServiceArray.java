/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import javax.ejb.Stateless;

/**
 *
 * @author Toshiba
 */
@Stateless
public class TestServiceArray {

    public void callTo(int[] marks) {
        for (int x : marks) {
            System.out.println(x);
        }
    }
}
