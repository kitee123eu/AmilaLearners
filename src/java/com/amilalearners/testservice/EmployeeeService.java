/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import com.amilalearners.model.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Toshiba
 */
@Stateless
public class EmployeeeService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;
    
    public void getUpdatedSalary() {
        String q = "select e from Employee e";
        Query query = em.createQuery(q);
        List <Employee> employeeList = query.getResultList();
       
        for(Employee e:employeeList)
        {
           if(e.getSalary()>10000)
           
           {
               e.setTotSalary(e.getSalary()+2000);
           }
           else
           {
               e.setTotSalary(e.getSalary());
           }
        }
        }
}
