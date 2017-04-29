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

/**
 *
 * @author Toshiba
 */
@Entity
@Table(name = "fuel")
@NamedQueries({
    @NamedQuery(name = "Fuel.findAll", query = "SELECT f FROM Fuel f"),
    @NamedQuery(name = "Fuel.findById", query = "SELECT f FROM Fuel f WHERE f.id = :id"),
    @NamedQuery(name = "Fuel.findByAmount", query = "SELECT f FROM Fuel f WHERE f.amount = :amount"),
    @NamedQuery(name = "Fuel.findByCost", query = "SELECT f FROM Fuel f WHERE f.cost = :cost"),
    @NamedQuery(name = "Fuel.findByFuelDate", query = "SELECT f FROM Fuel f WHERE f.fuelDate = :fuelDate")})
public class Fuel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fuelDate")
    @Temporal(TemporalType.DATE)
    private Date fuelDate;
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public Fuel() {
    }

    public Fuel(Integer id) {
        this.id = id;
    }

    public Fuel(Integer id, double amount, double cost, Date fuelDate) {
        this.id = id;
        this.amount = amount;
        this.cost = cost;
        this.fuelDate = fuelDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getFuelDate() {
        return fuelDate;
    }

    public void setFuelDate(Date fuelDate) {
        this.fuelDate = fuelDate;
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
        if (!(object instanceof Fuel)) {
            return false;
        }
        Fuel other = (Fuel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.Fuel[ id=" + id + " ]";
    }
    
}
