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
public class TestServicePara {

     public void displayParameter(int a, int b)
             
     {
         System.out.println(a+""+b);
     }
}
