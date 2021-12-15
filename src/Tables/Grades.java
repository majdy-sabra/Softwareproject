/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "GRADES")
@NamedQueries({
    @NamedQuery(name = "Grades.findAll", query = "SELECT g FROM Grades g"),
    @NamedQuery(name = "Grades.findById", query = "SELECT g FROM Grades g WHERE g.id = :id"),
    @NamedQuery(name = "Grades.findByFirstexam", query = "SELECT g FROM Grades g WHERE g.firstexam = :firstexam"),
    @NamedQuery(name = "Grades.findBySecondexam", query = "SELECT g FROM Grades g WHERE g.secondexam = :secondexam"),
    @NamedQuery(name = "Grades.findByFinalexam", query = "SELECT g FROM Grades g WHERE g.finalexam = :finalexam"),
    @NamedQuery(name = "Grades.findByAssignment1", query = "SELECT g FROM Grades g WHERE g.assignment1 = :assignment1"),
    @NamedQuery(name = "Grades.findByAssignment2", query = "SELECT g FROM Grades g WHERE g.assignment2 = :assignment2"),
    @NamedQuery(name = "Grades.findByAssignment3", query = "SELECT g FROM Grades g WHERE g.assignment3 = :assignment3"),
    @NamedQuery(name = "Grades.findByAssignment4", query = "SELECT g FROM Grades g WHERE g.assignment4 = :assignment4")})
public class Grades implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FIRSTEXAM")
    private BigInteger firstexam;
    @Column(name = "SECONDEXAM")
    private BigInteger secondexam;
    @Column(name = "FINALEXAM")
    private BigInteger finalexam;
    @Column(name = "ASSIGNMENT1")
    private BigInteger assignment1;
    @Column(name = "ASSIGNMENT2")
    private BigInteger assignment2;
    @Column(name = "ASSIGNMENT3")
    private BigInteger assignment3;
    @Column(name = "ASSIGNMENT4")
    private BigInteger assignment4;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StudentsSections studentsSections;

    public Grades() {
    }

    public Grades(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFirstexam() {
        return firstexam;
    }

    public void setFirstexam(BigInteger firstexam) {
        this.firstexam = firstexam;
    }

    public BigInteger getSecondexam() {
        return secondexam;
    }

    public void setSecondexam(BigInteger secondexam) {
        this.secondexam = secondexam;
    }

    public BigInteger getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(BigInteger finalexam) {
        this.finalexam = finalexam;
    }

    public BigInteger getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(BigInteger assignment1) {
        this.assignment1 = assignment1;
    }

    public BigInteger getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(BigInteger assignment2) {
        this.assignment2 = assignment2;
    }

    public BigInteger getAssignment3() {
        return assignment3;
    }

    public void setAssignment3(BigInteger assignment3) {
        this.assignment3 = assignment3;
    }

    public BigInteger getAssignment4() {
        return assignment4;
    }

    public void setAssignment4(BigInteger assignment4) {
        this.assignment4 = assignment4;
    }

    public StudentsSections getStudentsSections() {
        return studentsSections;
    }

    public void setStudentsSections(StudentsSections studentsSections) {
        this.studentsSections = studentsSections;
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
        if (!(object instanceof Grades)) {
            return false;
        }
        Grades other = (Grades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Grades[ id=" + id + " ]";
    }
    
}
