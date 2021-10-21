/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "DEPARTMENT")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentno", query = "SELECT d FROM Department d WHERE d.departmentno = :departmentno"),
    @NamedQuery(name = "Department.findByDepartmentname", query = "SELECT d FROM Department d WHERE d.departmentname = :departmentname"),
    @NamedQuery(name = "Department.findByCredithours", query = "SELECT d FROM Department d WHERE d.credithours = :credithours"),
    @NamedQuery(name = "Department.findByStydyplan", query = "SELECT d FROM Department d WHERE d.stydyplan = :stydyplan")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENTNO")
    private BigDecimal departmentno;
    @Column(name = "DEPARTMENTNAME")
    private String departmentname;
    @Column(name = "CREDITHOURS")
    private BigInteger credithours;
    @Column(name = "STYDYPLAN")
    private String stydyplan;
    @OneToMany(mappedBy = "depno")
    private Collection<Courses> coursesCollection;
    @OneToMany(mappedBy = "depNo")
    private Collection<Teachers> teachersCollection;

    public Department() {
    }

    public Department(BigDecimal departmentno) {
        this.departmentno = departmentno;
    }

    public BigDecimal getDepartmentno() {
        return departmentno;
    }

    public void setDepartmentno(BigDecimal departmentno) {
        this.departmentno = departmentno;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public BigInteger getCredithours() {
        return credithours;
    }

    public void setCredithours(BigInteger credithours) {
        this.credithours = credithours;
    }

    public String getStydyplan() {
        return stydyplan;
    }

    public void setStydyplan(String stydyplan) {
        this.stydyplan = stydyplan;
    }

    public Collection<Courses> getCoursesCollection() {
        return coursesCollection;
    }

    public void setCoursesCollection(Collection<Courses> coursesCollection) {
        this.coursesCollection = coursesCollection;
    }

    public Collection<Teachers> getTeachersCollection() {
        return teachersCollection;
    }

    public void setTeachersCollection(Collection<Teachers> teachersCollection) {
        this.teachersCollection = teachersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentno != null ? departmentno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentno == null && other.departmentno != null) || (this.departmentno != null && !this.departmentno.equals(other.departmentno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Department[ departmentno=" + departmentno + " ]";
    }
    
}
