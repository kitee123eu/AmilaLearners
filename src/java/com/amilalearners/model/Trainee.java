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
@Table(name = "trainee")
@NamedQueries({
    @NamedQuery(name = "Trainee.findAll", query = "SELECT t FROM Trainee t"),
    @NamedQuery(name = "Trainee.findById", query = "SELECT t FROM Trainee t WHERE t.id = :id"),
    @NamedQuery(name = "Trainee.findByNameWithInitials", query = "SELECT t FROM Trainee t WHERE t.nameWithInitials = :nameWithInitials"),
    @NamedQuery(name = "Trainee.findByFullName", query = "SELECT t FROM Trainee t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "Trainee.findByDateOfBirth", query = "SELECT t FROM Trainee t WHERE t.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Trainee.findByGender", query = "SELECT t FROM Trainee t WHERE t.gender = :gender"),
    @NamedQuery(name = "Trainee.findByCivilStatus", query = "SELECT t FROM Trainee t WHERE t.civilStatus = :civilStatus"),
    @NamedQuery(name = "Trainee.findByNicNo", query = "SELECT t FROM Trainee t WHERE t.nicNo = :nicNo"),
    @NamedQuery(name = "Trainee.findByInches", query = "SELECT t FROM Trainee t WHERE t.inches = :inches"),
    @NamedQuery(name = "Trainee.findByWeightKg", query = "SELECT t FROM Trainee t WHERE t.weightKg = :weightKg"),
    @NamedQuery(name = "Trainee.findByOccupation", query = "SELECT t FROM Trainee t WHERE t.occupation = :occupation"),
    @NamedQuery(name = "Trainee.findByContact1", query = "SELECT t FROM Trainee t WHERE t.contact1 = :contact1"),
    @NamedQuery(name = "Trainee.findByContact2", query = "SELECT t FROM Trainee t WHERE t.contact2 = :contact2"),
    @NamedQuery(name = "Trainee.findByEmail", query = "SELECT t FROM Trainee t WHERE t.email = :email"),
    @NamedQuery(name = "Trainee.findByPermanentAddressLine1", query = "SELECT t FROM Trainee t WHERE t.permanentAddressLine1 = :permanentAddressLine1"),
    @NamedQuery(name = "Trainee.findByPermanentAddressLine2", query = "SELECT t FROM Trainee t WHERE t.permanentAddressLine2 = :permanentAddressLine2"),
    @NamedQuery(name = "Trainee.findByPermanentAddressLine3", query = "SELECT t FROM Trainee t WHERE t.permanentAddressLine3 = :permanentAddressLine3"),
    @NamedQuery(name = "Trainee.findByContactAddressLine1", query = "SELECT t FROM Trainee t WHERE t.contactAddressLine1 = :contactAddressLine1"),
    @NamedQuery(name = "Trainee.findByContactAddressLine2", query = "SELECT t FROM Trainee t WHERE t.contactAddressLine2 = :contactAddressLine2"),
    @NamedQuery(name = "Trainee.findByContactAddressLine3", query = "SELECT t FROM Trainee t WHERE t.contactAddressLine3 = :contactAddressLine3"),
    @NamedQuery(name = "Trainee.findByCity", query = "SELECT t FROM Trainee t WHERE t.city = :city"),
    @NamedQuery(name = "Trainee.findByDistrict", query = "SELECT t FROM Trainee t WHERE t.district = :district"),
    @NamedQuery(name = "Trainee.findByDivisionalSecretariatOffice", query = "SELECT t FROM Trainee t WHERE t.divisionalSecretariatOffice = :divisionalSecretariatOffice"),
    @NamedQuery(name = "Trainee.findByNearestPoliceStation", query = "SELECT t FROM Trainee t WHERE t.nearestPoliceStation = :nearestPoliceStation"),
    @NamedQuery(name = "Trainee.findByClassApplying", query = "SELECT t FROM Trainee t WHERE t.classApplying = :classApplying"),
    @NamedQuery(name = "Trainee.findByAlreadyHavingLicense", query = "SELECT t FROM Trainee t WHERE t.alreadyHavingLicense = :alreadyHavingLicense"),
    @NamedQuery(name = "Trainee.findByLicenseNo", query = "SELECT t FROM Trainee t WHERE t.licenseNo = :licenseNo"),
    @NamedQuery(name = "Trainee.findByClass1", query = "SELECT t FROM Trainee t WHERE t.class1 = :class1"),
    @NamedQuery(name = "Trainee.findByDateOfIssued", query = "SELECT t FROM Trainee t WHERE t.dateOfIssued = :dateOfIssued"),
    @NamedQuery(name = "Trainee.findByDateOfExpire", query = "SELECT t FROM Trainee t WHERE t.dateOfExpire = :dateOfExpire"),
    @NamedQuery(name = "Trainee.findByDocumentIssuedId", query = "SELECT t FROM Trainee t WHERE t.documentIssuedId = :documentIssuedId"),
    @NamedQuery(name = "Trainee.findByClassId", query = "SELECT t FROM Trainee t WHERE t.classId = :classId"),
    @NamedQuery(name = "Trainee.findByRegisteredDate", query = "SELECT t FROM Trainee t WHERE t.registeredDate = :registeredDate")})
public class Trainee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
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
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "civilStatus")
    private String civilStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nicNo")
    private String nicNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inches")
    private double inches;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weightKg")
    private int weightKg;
    @Size(max = 50)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "contact1")
    private String contact1;
    @Size(max = 25)
    @Column(name = "contact2")
    private String contact2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
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
    @Column(name = "ContactAddressLine1")
    private String contactAddressLine1;
    @Size(max = 100)
    @Column(name = "ContactAddressLine2")
    private String contactAddressLine2;
    @Size(max = 100)
    @Column(name = "ContactAddressLine3")
    private String contactAddressLine3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "divisionalSecretariatOffice")
    private String divisionalSecretariatOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nearestPoliceStation")
    private String nearestPoliceStation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "classApplying")
    private String classApplying;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "alreadyHavingLicense")
    private String alreadyHavingLicense;
    @Size(max = 25)
    @Column(name = "licenseNo")
    private String licenseNo;
    @Size(max = 75)
    @Column(name = "class")
    private String class1;
    @Column(name = "dateOfIssued")
    @Temporal(TemporalType.DATE)
    private Date dateOfIssued;
    @Column(name = "dateOfExpire")
    @Temporal(TemporalType.DATE)
    private Date dateOfExpire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentIssuedId")
    private int documentIssuedId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classId")
    private int classId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registeredDate")
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    public Trainee() {
    }

    public Trainee(Integer id) {
        this.id = id;
    }

    public Trainee(Integer id, String nameWithInitials, String fullName, Date dateOfBirth, String gender, String civilStatus, String nicNo, double inches, int weightKg, String contact1, String email, String permanentAddressLine1, String permanentAddressLine2, String city, String district, String divisionalSecretariatOffice, String nearestPoliceStation, String classApplying, String alreadyHavingLicense, int documentIssuedId, int classId, Date registeredDate) {
        this.id = id;
        this.nameWithInitials = nameWithInitials;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.nicNo = nicNo;
        this.inches = inches;
        this.weightKg = weightKg;
        this.contact1 = contact1;
        this.email = email;
        this.permanentAddressLine1 = permanentAddressLine1;
        this.permanentAddressLine2 = permanentAddressLine2;
        this.city = city;
        this.district = district;
        this.divisionalSecretariatOffice = divisionalSecretariatOffice;
        this.nearestPoliceStation = nearestPoliceStation;
        this.classApplying = classApplying;
        this.alreadyHavingLicense = alreadyHavingLicense;
        this.documentIssuedId = documentIssuedId;
        this.classId = classId;
        this.registeredDate = registeredDate;
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

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivisionalSecretariatOffice() {
        return divisionalSecretariatOffice;
    }

    public void setDivisionalSecretariatOffice(String divisionalSecretariatOffice) {
        this.divisionalSecretariatOffice = divisionalSecretariatOffice;
    }

    public String getNearestPoliceStation() {
        return nearestPoliceStation;
    }

    public void setNearestPoliceStation(String nearestPoliceStation) {
        this.nearestPoliceStation = nearestPoliceStation;
    }

    public String getClassApplying() {
        return classApplying;
    }

    public void setClassApplying(String classApplying) {
        this.classApplying = classApplying;
    }

    public String getAlreadyHavingLicense() {
        return alreadyHavingLicense;
    }

    public void setAlreadyHavingLicense(String alreadyHavingLicense) {
        this.alreadyHavingLicense = alreadyHavingLicense;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public Date getDateOfIssued() {
        return dateOfIssued;
    }

    public void setDateOfIssued(Date dateOfIssued) {
        this.dateOfIssued = dateOfIssued;
    }

    public Date getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(Date dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public int getDocumentIssuedId() {
        return documentIssuedId;
    }

    public void setDocumentIssuedId(int documentIssuedId) {
        this.documentIssuedId = documentIssuedId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
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
        if (!(object instanceof Trainee)) {
            return false;
        }
        Trainee other = (Trainee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.Trainee[ id=" + id + " ]";
    }
    
}
