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
@Table(name = "vehicle")
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByRegistrationNo", query = "SELECT v FROM Vehicle v WHERE v.registrationNo = :registrationNo"),
    @NamedQuery(name = "Vehicle.findByRegistereddate", query = "SELECT v FROM Vehicle v WHERE v.registereddate = :registereddate"),
    @NamedQuery(name = "Vehicle.findByLicenseNo", query = "SELECT v FROM Vehicle v WHERE v.licenseNo = :licenseNo"),
    @NamedQuery(name = "Vehicle.findByAge", query = "SELECT v FROM Vehicle v WHERE v.age = :age"),
    @NamedQuery(name = "Vehicle.findByLicenseExpiresOn", query = "SELECT v FROM Vehicle v WHERE v.licenseExpiresOn = :licenseExpiresOn")})
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "registrationNo")
    private String registrationNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registereddate")
    @Temporal(TemporalType.DATE)
    private Date registereddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "licenseNo")
    private String licenseNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "licenseExpiresOn")
    @Temporal(TemporalType.DATE)
    private Date licenseExpiresOn;
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleCategory categoryId;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Vehicle(Integer id, String registrationNo, Date registereddate, String licenseNo, int age, Date licenseExpiresOn) {
        this.id = id;
        this.registrationNo = registrationNo;
        this.registereddate = registereddate;
        this.licenseNo = licenseNo;
        this.age = age;
        this.licenseExpiresOn = licenseExpiresOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Date getRegistereddate() {
        return registereddate;
    }

    public void setRegistereddate(Date registereddate) {
        this.registereddate = registereddate;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLicenseExpiresOn() {
        return licenseExpiresOn;
    }

    public void setLicenseExpiresOn(Date licenseExpiresOn) {
        this.licenseExpiresOn = licenseExpiresOn;
    }

    public VehicleCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(VehicleCategory categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.Vehicle[ id=" + id + " ]";
    }
    
}
