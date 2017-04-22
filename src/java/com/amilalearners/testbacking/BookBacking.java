/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.testservice.BookService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "bookBacking")
@ViewScoped
public class BookBacking {

   @EJB
   BookService bookService;
   public void displaySinhalaNovel()
   {
       bookService.getSinhalaNovel("Sinhala Novel");
   } 
   
   public void displayPrice400Novel()
   {
       bookService.get400PriceNovel();
   }
   
   public void displayBookCal()
   {
       bookService.getBookCal();
   }
   
   
    public void displayMaxPriceBook()
   {
       bookService.getMaxPriceBook();
   }
    
//     public void displayMinPriceBook()
//   {
//       bookService.getMinPriceBook();
//   }
   
    public void displaySinhalaNovelCategoryAmount()
   {
       bookService.getSinhalaNovelCategoryAmount("Sinhala Novel");
   
    
}
    
     public void displaySinhalaNovelCategoryAmountById()
   {
      // bookService.getSinhalaNovelCategoryAmountById("Sinhala Novel");
   
    
}
}
