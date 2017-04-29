/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Toshiba
 */
@Entity
@Table(name = "trial_schedule")
@NamedQueries({
    @NamedQuery(name = "TrialSchedule.findAll", query = "SELECT t FROM TrialSchedule t"),
    @NamedQuery(name = "TrialSchedule.findById", query = "SELECT t FROM TrialSchedule t WHERE t.id = :id"),
    @NamedQuery(name = "TrialSchedule.findByTrialDate", query = "SELECT t FROM TrialSchedule t WHERE t.trialDate = :trialDate"),
    @NamedQuery(name = "TrialSchedule.findByNoOfAttempts", query = "SELECT t FROM TrialSchedule t WHERE t.noOfAttempts = :noOfAttempts")})
public class TrialSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trialDate")
    @Temporal(TemporalType.DATE)
    private Date trialDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "noOfAttempts")
    private String noOfAttempts;
    @JoinColumn(name = "traineeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trainee traineeId;

    public TrialSchedule() {
    }

    public TrialSchedule(Integer id) {
        this.id = id;
    }

    public TrialSchedule(Integer id, Date trialDate, String noOfAttempts) {
        this.id = id;
        this.trialDate = trialDate;
        this.noOfAttempts = noOfAttempts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTrialDate() {
        return trialDate;
    }

    public void setTrialDate(Date trialDate) {
        this.trialDate = trialDate;
    }

    public String getNoOfAttempts() {
        return noOfAttempts;
    }

    public void setNoOfAttempts(String noOfAttempts) {
        this.noOfAttempts = noOfAttempts;
    }

    public Trainee getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Trainee traineeId) {
        this.traineeId = traineeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrialSchedule)) {
            return false;
        }
        TrialSchedule other = (TrialSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.TrialSchedule[ id=" + id + " ]";
    }
    
}
