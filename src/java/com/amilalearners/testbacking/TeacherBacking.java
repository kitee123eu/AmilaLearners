/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.testbacking;

import com.amilalearners.model.Teacher;
import com.amilalearners.testservice.TeacherService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Toshiba
 */
@Named(value = "teacherBacking")
@ViewScoped
public class TeacherBacking {

    @EJB
    TeacherService teacherService;
    
    @Named
    @Produces
    @RequestScoped
    Teacher teacher = new Teacher();

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    

     public String createTeacher() {
        teacher = teacherService.addNewTeacher(teacher);
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(teacher.getClass() + " Saved Successfully"));
        
        return null;

    }
}