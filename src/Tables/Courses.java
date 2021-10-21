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
import javax.persistence.Lob;
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
@Table(name = "COURSES")
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c"),
    @NamedQuery(name = "Courses.findByCourseno", query = "SELECT c FROM Courses c WHERE c.courseno = :courseno"),
    @NamedQuery(name = "Courses.findByCoursename", query = "SELECT c FROM Courses c WHERE c.coursename = :coursename"),
    @NamedQuery(name = "Courses.findByOutlineplan", query = "SELECT c FROM Courses c WHERE c.outlineplan = :outlineplan"),
    @NamedQuery(name = "Courses.findByImage", query = "SELECT c FROM Courses c WHERE c.image = :image")})
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COURSENO")
    private BigDecimal courseno;
    @Column(name = "COURSENAME")
    private String coursename;
    @Column(name = "OUTLINEPLAN")
    private String outlineplan;
    @Column(name = "IMAGE")
    private String image;
    @Lob
    @Column(name = "MESSAGE")
    private String message;
    @OneToMany(mappedBy = "courseno")
    private Collection<Sections> sectionsCollection;
    @JoinColumn(name = "DEPNO", referencedColumnName = "DEPARTMENTNO")
    @ManyToOne
    private Department depno;

    public Courses() {
    }

    public Courses(BigDecimal courseno) {
        this.courseno = courseno;
    }
    public Courses(BigDecimal courseno, String coursename, String outlineplan, String image, String message, Collection<Sections> sectionsCollection, Department depno) {
        this.courseno = courseno;
        this.coursename = coursename;
        this.outlineplan = outlineplan;
        this.image = image;
        this.message = message;
        this.sectionsCollection = sectionsCollection;
        this.depno = depno;
    }
    public BigDecimal getCourseno() {
        return courseno;
    }

    public void setCourseno(BigDecimal courseno) {
        this.courseno = courseno;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getOutlineplan() {
        return outlineplan;
    }

    public void setOutlineplan(String outlineplan) {
        this.outlineplan = outlineplan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<Sections> getSectionsCollection() {
        return sectionsCollection;
    }

    public void setSectionsCollection(Collection<Sections> sectionsCollection) {
        this.sectionsCollection = sectionsCollection;
    }

    public Department getDepno() {
        return depno;
    }

    public void setDepno(Department depno) {
        this.depno = depno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseno != null ? courseno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.courseno == null && other.courseno != null) || (this.courseno != null && !this.courseno.equals(other.courseno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Courses[ courseno=" + courseno + " ]";
    }
    
}
