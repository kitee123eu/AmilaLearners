/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.service;

import com.amilalearners.model.Movie;
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
public class MovieService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

//    public Movie addNewMovie(Movie movie) {
//        em.persist(movie);
//        return movie;
//
//    }
    public List<Movie> getMovieByCategory(int id) {
        Query query = em.createQuery("SELECT m FROM Movie m WHERE m.categoryId.id=:id");
        query.setParameter("id", id);
        List<Movie> movieList = query.getResultList();
        return movieList;
    }
}
