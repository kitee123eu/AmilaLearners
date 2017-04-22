/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import com.amilalearners.model.Category;
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
public class CategoryService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;
    public List<Category> getAllCategory()
    {
        Query query=em.createQuery("Select c from Category c");
        List<Category> categoryList= query.getResultList();
        return categoryList;
    }
}
