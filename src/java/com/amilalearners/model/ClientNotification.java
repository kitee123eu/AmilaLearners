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
@Table(name = "client_notification")
@NamedQueries({
    @NamedQuery(name = "ClientNotification.findAll", query = "SELECT c FROM ClientNotification c"),
    @NamedQuery(name = "ClientNotification.findById", query = "SELECT c FROM ClientNotification c WHERE c.id = :id"),
    @NamedQuery(name = "ClientNotification.findByNotifyDate", query = "SELECT c FROM ClientNotification c WHERE c.notifyDate = :notifyDate"),
    @NamedQuery(name = "ClientNotification.findByNotification", query = "SELECT c FROM ClientNotification c WHERE c.notification = :notification"),
    @NamedQuery(name = "ClientNotification.findByState", query = "SELECT c FROM ClientNotification c WHERE c.state = :state")})
public class ClientNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notifyDate")
    @Temporal(TemporalType.DATE)
    private Date notifyDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notification")
    @Temporal(TemporalType.DATE)
    private Date notification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "traineeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trainee traineeId;

    public ClientNotification() {
    }

    public ClientNotification(Integer id) {
        this.id = id;
    }

    public ClientNotification(Integer id, Date notifyDate, Date notification, String state) {
        this.id = id;
        this.notifyDate = notifyDate;
        this.notification = notification;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
    }

    public Date getNotification() {
        return notification;
    }

    public void setNotification(Date notification) {
        this.notification = notification;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        if (!(object instanceof ClientNotification)) {
            return false;
        }
        ClientNotification other = (ClientNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.ClientNotification[ id=" + id + " ]";
    }
    
}
