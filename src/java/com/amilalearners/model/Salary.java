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
@Table(name = "salary")
@NamedQueries({
    @NamedQuery(name = "Salary.findAll", query = "SELECT s FROM Salary s"),
    @NamedQuery(name = "Salary.findById", query = "SELECT s FROM Salary s WHERE s.id = :id"),
    @NamedQuery(name = "Salary.findByBasic", query = "SELECT s FROM Salary s WHERE s.basic = :basic"),
    @NamedQuery(name = "Salary.findByAllowances", query = "SELECT s FROM Salary s WHERE s.allowances = :allowances"),
    @NamedQuery(name = "Salary.findByBonus", query = "SELECT s FROM Salary s WHERE s.bonus = :bonus"),
    @NamedQuery(name = "Salary.findByGrossSalary", query = "SELECT s FROM Salary s WHERE s.grossSalary = :grossSalary"),
    @NamedQuery(name = "Salary.findByDeductions", query = "SELECT s FROM Salary s WHERE s.deductions = :deductions"),
    @NamedQuery(name = "Salary.findByNetSalary", query = "SELECT s FROM Salary s WHERE s.netSalary = :netSalary"),
    @NamedQuery(name = "Salary.findByTotal", query = "SELECT s FROM Salary s WHERE s.total = :total")})
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "basic")
    private long basic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allowances")
    private long allowances;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bonus")
    private long bonus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grossSalary")
    private long grossSalary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deductions")
    private long deductions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netSalary")
    private long netSalary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private long total;
    @JoinColumn(name = "staffId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Staff staffId;

    public Salary() {
    }

    public Salary(Integer id) {
        this.id = id;
    }

    public Salary(Integer id, long basic, long allowances, long bonus, long grossSalary, long deductions, long netSalary, long total) {
        this.id = id;
        this.basic = basic;
        this.allowances = allowances;
        this.bonus = bonus;
        this.grossSalary = grossSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getBasic() {
        return basic;
    }

    public void setBasic(long basic) {
        this.basic = basic;
    }

    public long getAllowances() {
        return allowances;
    }

    public void setAllowances(long allowances) {
        this.allowances = allowances;
    }

    public long getBonus() {
        return bonus;
    }

    public void setBonus(long bonus) {
        this.bonus = bonus;
    }

    public long getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(long grossSalary) {
        this.grossSalary = grossSalary;
    }

    public long getDeductions() {
        return deductions;
    }

    public void setDeductions(long deductions) {
        this.deductions = deductions;
    }

    public long getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(long netSalary) {
        this.netSalary = netSalary;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
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
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amilalearners.model.Salary[ id=" + id + " ]";
    }
    
}
