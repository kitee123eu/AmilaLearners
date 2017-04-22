/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import com.amilalearners.model.Profit;
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
public class GreaterService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public void getProfitByMonth() {
        String q = "select p from Profit p where p.netProfit>10000";
        Query query = em.createQuery(q);
        List<Profit> pList = query.getResultList();
        System.out.println(pList.size());

    }
}
