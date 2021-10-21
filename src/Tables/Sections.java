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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author c
 */
@Entity
@Table(name = "SECTIONS")
@NamedQueries({
    @NamedQuery(name = "Sections.findAll", query = "SELECT s FROM Sections s"),
    @NamedQuery(name = "Sections.findBySectionno", query = "SELECT s FROM Sections s WHERE s.sectionno = :sectionno"),
    @NamedQuery(name = "Sections.findByDatee", query = "SELECT s FROM Sections s WHERE s.datee = :datee")})
public class Sections implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SECTIONNO")
    private BigDecimal sectionno;
    @Column(name = "DATEE")
    private String datee;
    @JoinColumn(name = "COURSENO", referencedColumnName = "COURSENO")
    @ManyToOne
    private Courses courseno;
    @OneToMany(mappedBy = "sectionno")
    private Collection<TeachersSections> teachersSectionsCollection;
    @OneToMany(mappedBy = "sectionno")
    private Collection<StudentsSections> studentsSectionsCollection;

    public Sections() {
    }

    public Sections(BigDecimal sectionno) {
        this.sectionno = sectionno;
    }

    public BigDecimal getSectionno() {
        return sectionno;
    }

    public void setSectionno(BigDecimal sectionno) {
        this.sectionno = sectionno;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public Courses getCourseno() {
        return courseno;
    }

    public void setCourseno(Courses courseno) {
        this.courseno = courseno;
    }

    public Collection<TeachersSections> getTeachersSectionsCollection() {
        return teachersSectionsCollection;
    }

    public void setTeachersSectionsCollection(Collection<TeachersSections> teachersSectionsCollection) {
        this.teachersSectionsCollection = teachersSectionsCollection;
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
        hash += (sectionno != null ? sectionno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sections)) {
            return false;
        }
        Sections other = (Sections) object;
        if ((this.sectionno == null && other.sectionno != null) || (this.sectionno != null && !this.sectionno.equals(other.sectionno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Sections[ sectionno=" + sectionno + " ]";
    }
    
}
