/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.admin.backingbean;

import com.amilalearners.model.Category;
import com.amilalearners.model.Movie;
import com.amilalearners.service.CategoryService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "movieAddBacking")
@ViewScoped
public class MovieAddBacking {

    @EJB     //ejb yatama tiyena variable walata getter setter hadanne ne
    CategoryService categoryService;
    
    List<Category> categoryList;
    
//    public void test() {
//        List<Category> categoryList = categoryService.getAllCategory();
//        for (Category c : categoryList) {                                        //for loop
//            System.out.println(c.getCategoryName());
//        }
//    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        
    }
    @PostConstruct
    public void init()
    {
        categoryList= categoryService.getAllCategory();
    }
    
    @Named
    @Produces
    @RequestScoped
    Movie movie=new Movie();
    

}
