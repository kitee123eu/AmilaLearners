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
@Table(name = "learners_user")
@NamedQueries({
    @NamedQuery(name = "LearnersUser.findAll", query = "SELECT l FROM LearnersUser l"),
    @NamedQuery(name = "LearnersUser.findByEmail", query = "SELECT l FROM LearnersUser l WHERE l.email = :email"),
    @NamedQuery(name = "LearnersUser.findByFirstName", query = "SELECT l FROM LearnersUser l WHERE l.firstName = :firstName"),
    @NamedQuery(name = "LearnersUser.findByLastName", query = "SELECT l FROM LearnersUser l WHERE l.lastName = :lastName"),
    @NamedQuery(name = "LearnersUser.findByPassword", query = "SELECT l FROM LearnersUser l WHERE l.password = :password")})
public class LearnersUser implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private List<LearnersRole> learnersRoleList;

    public LearnersUser() {
    }

    public LearnersUser(String email) {
        this.email = email;
    }

    public LearnersUser(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LearnersRole> getLearnersRoleList() {
        return learnersRoleList;
    }

    public void setLearnersRoleList(List<LearnersRole> learnersRoleList) {
        this.learnersRoleList = learnersRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearnersUser)) {
            return false;
        }
        LearnersUser other = (LearnersUser) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.LearnersUser[ email=" + email + " ]";
    }
    
}
