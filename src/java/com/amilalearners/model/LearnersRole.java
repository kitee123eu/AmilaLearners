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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Toshiba
 */
@Entity
@Table(name = "learners_role")
@NamedQueries({
    @NamedQuery(name = "LearnersRole.findAll", query = "SELECT l FROM LearnersRole l"),
    @NamedQuery(name = "LearnersRole.findById", query = "SELECT l FROM LearnersRole l WHERE l.id = :id"),
    @NamedQuery(name = "LearnersRole.findByRoleId", query = "SELECT l FROM LearnersRole l WHERE l.roleId = :roleId")})
public class LearnersRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roleId")
    private int roleId;
    @JoinColumn(name = "userEmail", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private LearnersUser userEmail;

    public LearnersRole() {
    }

    public LearnersRole(Integer id) {
        this.id = id;
    }

    public LearnersRole(Integer id, int roleId) {
        this.id = id;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public LearnersUser getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(LearnersUser userEmail) {
        this.userEmail = userEmail;
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
        if (!(object instanceof LearnersRole)) {
            return false;
        }
        LearnersRole other = (LearnersRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.LearnersRole[ id=" + id + " ]";
    }
    
}
