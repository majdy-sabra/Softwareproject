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
@Table(name = "TEACHERS")
@NamedQueries({
    @NamedQuery(name = "Teachers.findAll", query = "SELECT t FROM Teachers t"),
    @NamedQuery(name = "Teachers.findByTeacherid", query = "SELECT t FROM Teachers t WHERE t.teacherid = :teacherid"),
    @NamedQuery(name = "Teachers.findByTeachername", query = "SELECT t FROM Teachers t WHERE t.teachername = :teachername"),
    @NamedQuery(name = "Teachers.findByEmail", query = "SELECT t FROM Teachers t WHERE t.email = :email"),
    @NamedQuery(name = "Teachers.findByPhone", query = "SELECT t FROM Teachers t WHERE t.phone = :phone"),
    @NamedQuery(name = "Teachers.findByTeacherpassword", query = "SELECT t FROM Teachers t WHERE t.teacherpassword = :teacherpassword"),
    @NamedQuery(name = "Teachers.findByTmode", query = "SELECT t FROM Teachers t WHERE t.tmode = :tmode")})
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TEACHERID")
    private BigDecimal teacherid;
    @Column(name = "TEACHERNAME")
    private String teachername;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "TEACHERPASSWORD")
    private String teacherpassword;
    @Column(name = "TMODE")
    private String tmode;
    @OneToMany(mappedBy = "teacherid")
    private Collection<TeachersSections> teachersSectionsCollection;
    @JoinColumn(name = "DEP_NO", referencedColumnName = "DEPARTMENTNO")
    @ManyToOne
    private Department depNo;

    public Teachers() {
    }

    public Teachers(BigDecimal teacherid) {
        this.teacherid = teacherid;
    }

    public BigDecimal getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(BigDecimal teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeacherpassword() {
        return teacherpassword;
    }

    public void setTeacherpassword(String teacherpassword) {
        this.teacherpassword = teacherpassword;
    }

    public String getTmode() {
        return tmode;
    }

    public void setTmode(String tmode) {
        this.tmode = tmode;
    }

    public Collection<TeachersSections> getTeachersSectionsCollection() {
        return teachersSectionsCollection;
    }

    public void setTeachersSectionsCollection(Collection<TeachersSections> teachersSectionsCollection) {
        this.teachersSectionsCollection = teachersSectionsCollection;
    }

    public Department getDepNo() {
        return depNo;
    }

    public void setDepNo(Department depNo) {
        this.depNo = depNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherid != null ? teacherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachers)) {
            return false;
        }
        Teachers other = (Teachers) object;
        if ((this.teacherid == null && other.teacherid != null) || (this.teacherid != null && !this.teacherid.equals(other.teacherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Teachers[ teacherid=" + teacherid + " ]";
    }
    
}
