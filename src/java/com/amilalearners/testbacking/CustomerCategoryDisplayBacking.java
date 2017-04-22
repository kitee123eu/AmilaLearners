/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.model.Category;
import com.amilalearners.service.CategoryService;
import com.amilalearners.testservice.CustomerCategoryService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "customerCategoryDisplayBacking")
@ViewScoped
public class CustomerCategoryDisplayBacking {

   @EJB
   CategoryService categoryService;
   
   List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
    public void readCategoryList()
    {
        categoryList=categoryService.getAllCategory();
    }

   
    
   
}
