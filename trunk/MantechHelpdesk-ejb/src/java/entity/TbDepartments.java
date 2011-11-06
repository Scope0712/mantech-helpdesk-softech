/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbDepartments")
@NamedQueries({
    @NamedQuery(name = "TbDepartments.findAll", query = "SELECT t FROM TbDepartments t"),
    @NamedQuery(name = "TbDepartments.findByDepartmentId", query = "SELECT t FROM TbDepartments t WHERE t.departmentId = :departmentId"),
    @NamedQuery(name = "TbDepartments.findByDepartmentName", query = "SELECT t FROM TbDepartments t WHERE t.departmentName = :departmentName"),
    @NamedQuery(name = "TbDepartments.findByPriority", query = "SELECT t FROM TbDepartments t WHERE t.priority = :priority")})
public class TbDepartments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Department_Id")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "Department_Name")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "Priority")
    private int priority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbDepartments")
    private Collection<Report> reportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbDepartments")
    private Collection<TbStaffs> tbStaffsCollection;

    public TbDepartments() {
    }

    public TbDepartments(String departmentId) {
        this.departmentId = departmentId;
    }

    public TbDepartments(String departmentId, String departmentName, int priority) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.priority = priority;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    public Collection<TbStaffs> getTbStaffsCollection() {
        return tbStaffsCollection;
    }

    public void setTbStaffsCollection(Collection<TbStaffs> tbStaffsCollection) {
        this.tbStaffsCollection = tbStaffsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDepartments)) {
            return false;
        }
        TbDepartments other = (TbDepartments) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbDepartments[departmentId=" + departmentId + "]";
    }

}
