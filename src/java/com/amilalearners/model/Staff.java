/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Toshiba
 */
@Entity
@Table(name = "staff")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findById", query = "SELECT s FROM Staff s WHERE s.id = :id"),
    @NamedQuery(name = "Staff.findByNameWithInitials", query = "SELECT s FROM Staff s WHERE s.nameWithInitials = :nameWithInitials"),
    @NamedQuery(name = "Staff.findByFullName", query = "SELECT s FROM Staff s WHERE s.fullName = :fullName"),
    @NamedQuery(name = "Staff.findByDateOfBirth", query = "SELECT s FROM Staff s WHERE s.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Staff.findByGender", query = "SELECT s FROM Staff s WHERE s.gender = :gender"),
    @NamedQuery(name = "Staff.findByNic", query = "SELECT s FROM Staff s WHERE s.nic = :nic"),
    @NamedQuery(name = "Staff.findByCivilStatus", query = "SELECT s FROM Staff s WHERE s.civilStatus = :civilStatus"),
    @NamedQuery(name = "Staff.findByOccupation", query = "SELECT s FROM Staff s WHERE s.occupation = :occupation"),
    @NamedQuery(name = "Staff.findByContactHome", query = "SELECT s FROM Staff s WHERE s.contactHome = :contactHome"),
    @NamedQuery(name = "Staff.findByContactMobile", query = "SELECT s FROM Staff s WHERE s.contactMobile = :contactMobile"),
    @NamedQuery(name = "Staff.findByEmail", query = "SELECT s FROM Staff s WHERE s.email = :email"),
    @NamedQuery(name = "Staff.findByPermanentAddressLine1", query = "SELECT s FROM Staff s WHERE s.permanentAddressLine1 = :permanentAddressLine1"),
    @NamedQuery(name = "Staff.findByPermanentAddressLine2", query = "SELECT s FROM Staff s WHERE s.permanentAddressLine2 = :permanentAddressLine2"),
    @NamedQuery(name = "Staff.findByPermanentAddressLine3", query = "SELECT s FROM Staff s WHERE s.permanentAddressLine3 = :permanentAddressLine3"),
    @NamedQuery(name = "Staff.findByContactAddressLine1", query = "SELECT s FROM Staff s WHERE s.contactAddressLine1 = :contactAddressLine1"),
    @NamedQuery(name = "Staff.findByContactAddressLine2", query = "SELECT s FROM Staff s WHERE s.contactAddressLine2 = :contactAddressLine2"),
    @NamedQuery(name = "Staff.findByContactAddressLine3", query = "SELECT s FROM Staff s WHERE s.contactAddressLine3 = :contactAddressLine3"),
    @NamedQuery(name = "Staff.findByDateOfRecruited", query = "SELECT s FROM Staff s WHERE s.dateOfRecruited = :dateOfRecruited"),
    @NamedQuery(name = "Staff.findByCurrentStatus", query = "SELECT s FROM Staff s WHERE s.currentStatus = :currentStatus"),
    @NamedQuery(name = "Staff.findByDateOfLeft", query = "SELECT s FROM Staff s WHERE s.dateOfLeft = :dateOfLeft")})
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nameWithInitials")
    private String nameWithInitials;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nic")
    private String nic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "civilStatus")
    private String civilStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "contactHome")
    private String contactHome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "contactMobile")
    private String contactMobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "permanentAddressLine1")
    private String permanentAddressLine1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "permanentAddressLine2")
    private String permanentAddressLine2;
    @Size(max = 100)
    @Column(name = "permanentAddressLine3")
    private String permanentAddressLine3;
    @Size(max = 100)
    @Column(name = "contactAddressLine1")
    private String contactAddressLine1;
    @Size(max = 100)
    @Column(name = "contactAddressLine2")
    private String contactAddressLine2;
    @Size(max = 100)
    @Column(name = "contactAddressLine3")
    private String contactAddressLine3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfRecruited")
    @Temporal(TemporalType.DATE)
    private Date dateOfRecruited;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "currentStatus")
    private String currentStatus;
    @Column(name = "dateOfLeft")
    @Temporal(TemporalType.DATE)
    private Date dateOfLeft;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<Salary> salaryList;

    public Staff() {
    }

    public Staff(Integer id) {
        this.id = id;
    }

    public Staff(Integer id, String nameWithInitials, String fullName, Date dateOfBirth, String gender, String nic, String civilStatus, String occupation, String contactHome, String contactMobile, String email, String permanentAddressLine1, String permanentAddressLine2, Date dateOfRecruited, String currentStatus) {
        this.id = id;
        this.nameWithInitials = nameWithInitials;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nic = nic;
        this.civilStatus = civilStatus;
        this.occupation = occupation;
        this.contactHome = contactHome;
        this.contactMobile = contactMobile;
        this.email = email;
        this.permanentAddressLine1 = permanentAddressLine1;
        this.permanentAddressLine2 = permanentAddressLine2;
        this.dateOfRecruited = dateOfRecruited;
        this.currentStatus = currentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameWithInitials() {
        return nameWithInitials;
    }

    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContactHome() {
        return contactHome;
    }

    public void setContactHome(String contactHome) {
        this.contactHome = contactHome;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentAddressLine2() {
        return permanentAddressLine2;
    }

    public void setPermanentAddressLine2(String permanentAddressLine2) {
        this.permanentAddressLine2 = permanentAddressLine2;
    }

    public String getPermanentAddressLine3() {
        return permanentAddressLine3;
    }

    public void setPermanentAddressLine3(String permanentAddressLine3) {
        this.permanentAddressLine3 = permanentAddressLine3;
    }

    public String getContactAddressLine1() {
        return contactAddressLine1;
    }

    public void setContactAddressLine1(String contactAddressLine1) {
        this.contactAddressLine1 = contactAddressLine1;
    }

    public String getContactAddressLine2() {
        return contactAddressLine2;
    }

    public void setContactAddressLine2(String contactAddressLine2) {
        this.contactAddressLine2 = contactAddressLine2;
    }

    public String getContactAddressLine3() {
        return contactAddressLine3;
    }

    public void setContactAddressLine3(String contactAddressLine3) {
        this.contactAddressLine3 = contactAddressLine3;
    }

    public Date getDateOfRecruited() {
        return dateOfRecruited;
    }

    public void setDateOfRecruited(Date dateOfRecruited) {
        this.dateOfRecruited = dateOfRecruited;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Date getDateOfLeft() {
        return dateOfLeft;
    }

    public void setDateOfLeft(Date dateOfLeft) {
        this.dateOfLeft = dateOfLeft;
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
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
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.Staff[ id=" + id + " ]";
    }
    
}
