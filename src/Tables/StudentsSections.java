/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author c
 */
@Entity
@Table(name = "STUDENTS_SECTIONS")
@NamedQueries({
    @NamedQuery(name = "StudentsSections.findAll", query = "SELECT s FROM StudentsSections s"),
    @NamedQuery(name = "StudentsSections.findById", query = "SELECT s FROM StudentsSections s WHERE s.id = :id"),
    @NamedQuery(name = "StudentsSections.findByFinalgrade", query = "SELECT s FROM StudentsSections s WHERE s.finalgrade = :finalgrade")})
public class StudentsSections implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FINALGRADE")
    private String finalgrade;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentsSections")
    private Grades grades;
    @JoinColumn(name = "SECTIONNO", referencedColumnName = "SECTIONNO")
    @ManyToOne
    private Sections sectionno;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @ManyToOne
    private Students studentid;

    public StudentsSections() {
    }

    public StudentsSections(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFinalgrade() {
        return finalgrade;
    }

    public void setFinalgrade(String finalgrade) {
        this.finalgrade = finalgrade;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public Sections getSectionno() {
        return sectionno;
    }

    public void setSectionno(Sections sectionno) {
        this.sectionno = sectionno;
    }

    public Students getStudentid() {
        return studentid;
    }

    public void setStudentid(Students studentid) {
        this.studentid = studentid;
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
        if (!(object instanceof StudentsSections)) {
            return false;
        }
        StudentsSections other = (StudentsSections) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.StudentsSections[ id=" + id + " ]";
    }
    
}
