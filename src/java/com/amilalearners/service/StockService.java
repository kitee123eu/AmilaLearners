/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import com.amilalearners.model.Stock;
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
public class StockService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public List<Stock> getAllStock() {
        Query query = em.createNamedQuery("Stock.findAll", Stock.class);
        List<Stock> itemStock = query.getResultList();
        return itemStock;
    }
}
