/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
 * @author Jenan
 */
@Entity
@Table(name = "SUBMISSION")
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findBySubmissionno", query = "SELECT s FROM Submission s WHERE s.submissionno = :submissionno"),
    @NamedQuery(name = "Submission.findByLink", query = "SELECT s FROM Submission s WHERE s.link = :link")})
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SUBMISSIONNO")
    private BigDecimal submissionno;
    @Column(name = "LINK")
    private String link;
    @JoinColumn(name = "ASSIGNMENTNO", referencedColumnName = "ASSIGNMENTNO")
    @ManyToOne
    private Assignments assignmentno;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @ManyToOne
    private Students studentid;

    public Submission() {
    }

    public Submission(BigDecimal submissionno) {
        this.submissionno = submissionno;
    }

    public BigDecimal getSubmissionno() {
        return submissionno;
    }

    public void setSubmissionno(BigDecimal submissionno) {
        this.submissionno = submissionno;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Assignments getAssignmentno() {
        return assignmentno;
    }

    public void setAssignmentno(Assignments assignmentno) {
        this.assignmentno = assignmentno;
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
        hash += (submissionno != null ? submissionno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.submissionno == null && other.submissionno != null) || (this.submissionno != null && !this.submissionno.equals(other.submissionno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Submission[ submissionno=" + submissionno + " ]";
    }
    
}
