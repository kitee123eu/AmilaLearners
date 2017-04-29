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
@Table(name = "vehicle_service")
@NamedQueries({
    @NamedQuery(name = "VehicleService.findAll", query = "SELECT v FROM VehicleService v"),
    @NamedQuery(name = "VehicleService.findById", query = "SELECT v FROM VehicleService v WHERE v.id = :id"),
    @NamedQuery(name = "VehicleService.findByServiceDate", query = "SELECT v FROM VehicleService v WHERE v.serviceDate = :serviceDate"),
    @NamedQuery(name = "VehicleService.findByServiceType", query = "SELECT v FROM VehicleService v WHERE v.serviceType = :serviceType"),
    @NamedQuery(name = "VehicleService.findByDescription", query = "SELECT v FROM VehicleService v WHERE v.description = :description"),
    @NamedQuery(name = "VehicleService.findByCost", query = "SELECT v FROM VehicleService v WHERE v.cost = :cost")})
public class VehicleService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serviceDate")
    @Temporal(TemporalType.DATE)
    private Date serviceDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "serviceType")
    private String serviceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public VehicleService() {
    }

    public VehicleService(Integer id) {
        this.id = id;
    }

    public VehicleService(Integer id, Date serviceDate, String serviceType, String description, double cost) {
        this.id = id;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.description = description;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
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
        if (!(object instanceof VehicleService)) {
            return false;
        }
        VehicleService other = (VehicleService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.VehicleService[ id=" + id + " ]";
    }
    
}
