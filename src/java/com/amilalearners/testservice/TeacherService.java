/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testservice;

import com.amilalearners.model.Teacher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Toshiba
 */
@Stateless
public class TeacherService {

    @PersistenceContext(unitName = "AmilaLearnersPU")
    EntityManager em;

    public Teacher addNewTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;

    }
}
