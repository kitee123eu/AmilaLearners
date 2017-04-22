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
@Table(name = "vehicle_category")
@NamedQueries({
    @NamedQuery(name = "VehicleCategory.findAll", query = "SELECT v FROM VehicleCategory v"),
    @NamedQuery(name = "VehicleCategory.findById", query = "SELECT v FROM VehicleCategory v WHERE v.id = :id"),
    @NamedQuery(name = "VehicleCategory.findByVehicleType", query = "SELECT v FROM VehicleCategory v WHERE v.vehicleType = :vehicleType")})
public class VehicleCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vehicleType")
    private String vehicleType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<Vehicle> vehicleList;

    public VehicleCategory() {
    }

    public VehicleCategory(Integer id) {
        this.id = id;
    }

    public VehicleCategory(Integer id, String vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
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
        if (!(object instanceof VehicleCategory)) {
            return false;
        }
        VehicleCategory other = (VehicleCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.VehicleCategory[ id=" + id + " ]";
    }
    
}
