/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author c
 */
@Entity
@Table(name = "STUDENTS")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByStudentid", query = "SELECT s FROM Students s WHERE s.studentid = :studentid"),
    @NamedQuery(name = "Students.findByStudentname", query = "SELECT s FROM Students s WHERE s.studentname = :studentname"),
    @NamedQuery(name = "Students.findByStudentpassword", query = "SELECT s FROM Students s WHERE s.studentpassword = :studentpassword")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENTID")
    private BigDecimal studentid;
    @Column(name = "STUDENTNAME")
    private String studentname;
    @Column(name = "STUDENTPASSWORD")
    private String studentpassword;
    @OneToMany(mappedBy = "studentid")
    private Collection<StudentsSections> studentsSectionsCollection;

    public Students() {
    }

    public Students(BigDecimal studentid) {
        this.studentid = studentid;
    }

    public BigDecimal getStudentid() {
        return studentid;
    }

    public void setStudentid(BigDecimal studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }

    public Collection<StudentsSections> getStudentsSectionsCollection() {
        return studentsSectionsCollection;
    }

    public void setStudentsSectionsCollection(Collection<StudentsSections> studentsSectionsCollection) {
        this.studentsSectionsCollection = studentsSectionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Students[ studentid=" + studentid + " ]";
    }
    
}
