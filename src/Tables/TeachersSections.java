/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author c
 */
@Entity
@Table(name = "TEACHERS_SECTIONS")
@NamedQueries({
    @NamedQuery(name = "TeachersSections.findAll", query = "SELECT t FROM TeachersSections t"),
    @NamedQuery(name = "TeachersSections.findById", query = "SELECT t FROM TeachersSections t WHERE t.id = :id")})
public class TeachersSections implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "SECTIONNO", referencedColumnName = "SECTIONNO")
    @ManyToOne
    private Sections sectionno;
    @JoinColumn(name = "TEACHERID", referencedColumnName = "TEACHERID")
    @ManyToOne
    private Teachers teacherid;

    public TeachersSections() {
    }

    public TeachersSections(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Sections getSectionno() {
        return sectionno;
    }

    public void setSectionno(Sections sectionno) {
        this.sectionno = sectionno;
    }

    public Teachers getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Teachers teacherid) {
        this.teacherid = teacherid;
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
        if (!(object instanceof TeachersSections)) {
            return false;
        }
        TeachersSections other = (TeachersSections) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.TeachersSections[ id=" + id + " ]";
    }
    
}
