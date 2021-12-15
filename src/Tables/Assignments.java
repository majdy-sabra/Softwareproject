/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
 * @author Jenan
 */
@Entity
@Table(name = "ASSIGNMENTS")
@NamedQueries({
    @NamedQuery(name = "Assignments.findAll", query = "SELECT a FROM Assignments a"),
    @NamedQuery(name = "Assignments.findByAssignmentno", query = "SELECT a FROM Assignments a WHERE a.assignmentno = :assignmentno"),
    @NamedQuery(name = "Assignments.findByLink", query = "SELECT a FROM Assignments a WHERE a.link = :link"),
    @NamedQuery(name = "Assignments.findByPermission", query = "SELECT a FROM Assignments a WHERE a.permission = :permission")})
public class Assignments implements Serializable {

    @Column(name = "PERMISSION2")
    private String permission2;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ASSIGNMENTNO")
    private BigDecimal assignmentno;
    @Column(name = "LINK")
    private String link;
    @Column(name = "PERMISSION")
    private String permission;
    @OneToMany(mappedBy = "assignmentno")
    private Collection<Submission> submissionCollection;
    @JoinColumn(name = "SECTIONNO", referencedColumnName = "SECTIONNO")
    @ManyToOne
    private Sections sectionno;

    public Assignments() {
    }

    public Assignments(BigDecimal assignmentno) {
        this.assignmentno = assignmentno;
    }

    public BigDecimal getAssignmentno() {
        return assignmentno;
    }

    public void setAssignmentno(BigDecimal assignmentno) {
        this.assignmentno = assignmentno;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Collection<Submission> getSubmissionCollection() {
        return submissionCollection;
    }

    public void setSubmissionCollection(Collection<Submission> submissionCollection) {
        this.submissionCollection = submissionCollection;
    }

    public Sections getSectionno() {
        return sectionno;
    }

    public void setSectionno(Sections sectionno) {
        this.sectionno = sectionno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentno != null ? assignmentno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignments)) {
            return false;
        }
        Assignments other = (Assignments) object;
        if ((this.assignmentno == null && other.assignmentno != null) || (this.assignmentno != null && !this.assignmentno.equals(other.assignmentno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Assignments[ assignmentno=" + assignmentno + " ]";
    }


    public String getPermission2() {
        return permission2;
    }

    public void setPermission2(String permission2) {
        this.permission2 = permission2;
    }
    
}
