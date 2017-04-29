/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Toshiba
 */
@Entity
@Table(name = "license_class")
@NamedQueries({
    @NamedQuery(name = "LicenseClass.findAll", query = "SELECT l FROM LicenseClass l"),
    @NamedQuery(name = "LicenseClass.findById", query = "SELECT l FROM LicenseClass l WHERE l.id = :id"),
    @NamedQuery(name = "LicenseClass.findByClass1", query = "SELECT l FROM LicenseClass l WHERE l.class1 = :class1"),
    @NamedQuery(name = "LicenseClass.findByClassDescription", query = "SELECT l FROM LicenseClass l WHERE l.classDescription = :classDescription"),
    @NamedQuery(name = "LicenseClass.findByTotalFee", query = "SELECT l FROM LicenseClass l WHERE l.totalFee = :totalFee"),
    @NamedQuery(name = "LicenseClass.findByBasicFee", query = "SELECT l FROM LicenseClass l WHERE l.basicFee = :basicFee")})
public class LicenseClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "class")
    private String class1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "class_Description")
    private String classDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_Fee")
    private long totalFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "basic_Fee")
    private long basicFee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenseClassId")
    private List<LicenseApplied> licenseAppliedList;

    public LicenseClass() {
    }

    public LicenseClass(Integer id) {
        this.id = id;
    }

    public LicenseClass(Integer id, String class1, String classDescription, long totalFee, long basicFee) {
        this.id = id;
        this.class1 = class1;
        this.classDescription = classDescription;
        this.totalFee = totalFee;
        this.basicFee = basicFee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(long totalFee) {
        this.totalFee = totalFee;
    }

    public long getBasicFee() {
        return basicFee;
    }

    public void setBasicFee(long basicFee) {
        this.basicFee = basicFee;
    }

    public List<LicenseApplied> getLicenseAppliedList() {
        return licenseAppliedList;
    }

    public void setLicenseAppliedList(List<LicenseApplied> licenseAppliedList) {
        this.licenseAppliedList = licenseAppliedList;
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
        if (!(object instanceof LicenseClass)) {
            return false;
        }
        LicenseClass other = (LicenseClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.LicenseClass[ id=" + id + " ]";
    }
    
}
