/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import com.amilalearners.model.Book;
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
public class BookService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public void getSinhalaNovel(String typeName) {

        String q = "select b from Book b where b.typeId.typeName=:typeName";
        Query query = em.createQuery(q);

        query.setParameter("typeName", typeName);

        List<Book> bookList = query.getResultList();
        for (Book b : bookList) {
            System.out.println(b.getTitle());
        }
    }

    public void get400PriceNovel() {

        String q = "select b from Book b where b.sellingPrice=400";
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();
        for (Book b : bookList) {
            System.out.println(b.getTitle());
        }
    }

    public void getBookCal() {

        String q = "select b from Book b";
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();
        int total = 0;
        for (Book b : bookList) {
            total = (int) (total + b.getSellingPrice() * b.getStockInHand());
        }
        System.out.println(total);
    }

    public void getMaxPriceBook() {

        String q = "select b from Book b";
        Query query = em.createQuery(q);
        List<Book> bookList = query.getResultList();

        int max = 0;

        Book maxBook = new Book();
        for (Book b : bookList) {

            if (max < b.getSellingPrice().intValue()) 
            {
                max = b.getSellingPrice().intValue();
                maxBook=b;
            }
        }
            System.out.println(max+ maxBook.getTitle());

        }
    
//     public void getMinPriceBook() {   try at home
//
//        String q = "select b from Book b";
//        Query query = em.createQuery(q);
//        List<Book> bookList = query.getResultList();
//
//        int min =0;
//
//        Book minBook = new Book();
//        for (Book b : bookList) {
//
//            if (min > b.getSellingPrice().intValue()) 
//            {
//                min = b.getSellingPrice().intValue();
//                minBook=b;
//            }
//        }
//            System.out.println(min+ minBook.getTitle());
//
//        }
    
    
    
    
    public void getSinhalaNovelCategoryAmount(String typeName) {

        String q = "select b from Book b where b.typeId.typeName=:typeName";
        Query query = em.createQuery(q);

        query.setParameter("typeName", typeName);

        List<Book> bookList = query.getResultList();
        for (Book b : bookList) {
            
           // System.out.println(b.getTitle());
            System.out.println(bookList.size());
        }
    
    
    
    }
    
//     public void getSinhalaNovelCategoryAmountById(String typeName) {
//
//        String q = "select b from Book b where b.typeId.typeName=:typeName";
//        Query query = em.createQuery(q);
//
//        query.setParameter("typeName", typeName);
//
//        List<Book> bookList = query.getResultList();
//        for (Book b : bookList) {
//            
//           // System.out.println(b.getTitle());
//            System.out.println(bookList.size());
//        }
    
    
    
    }
    

