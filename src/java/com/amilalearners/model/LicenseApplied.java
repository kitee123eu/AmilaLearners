/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.model;

import java.io.Serializable;
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

/**
 *
 * @author Toshiba
 */
@Entity
@Table(name = "license_applied")
@NamedQueries({
    @NamedQuery(name = "LicenseApplied.findAll", query = "SELECT l FROM LicenseApplied l"),
    @NamedQuery(name = "LicenseApplied.findById", query = "SELECT l FROM LicenseApplied l WHERE l.id = :id")})
public class LicenseApplied implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "licenseClassId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LicenseClass licenseClassId;
    @JoinColumn(name = "traineeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trainee traineeId;

    public LicenseApplied() {
    }

    public LicenseApplied(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LicenseClass getLicenseClassId() {
        return licenseClassId;
    }

    public void setLicenseClassId(LicenseClass licenseClassId) {
        this.licenseClassId = licenseClassId;
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
        if (!(object instanceof LicenseApplied)) {
            return false;
        }
        LicenseApplied other = (LicenseApplied) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.LicenseApplied[ id=" + id + " ]";
    }
    
}
