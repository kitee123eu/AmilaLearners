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
public class TestService1Cal {

    public int callTo(int[] marks) {
        int cal=0;
        for (int x : marks) {
            cal=cal+x;
  }
        return cal;
    }
}