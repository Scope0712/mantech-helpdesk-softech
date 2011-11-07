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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tbComplaints", catalog = "MantechHelpdesk", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TbComplaints.findAll", query = "SELECT t FROM TbComplaints t"),
    @NamedQuery(name = "TbComplaints.findByComplaintId", query = "SELECT t FROM TbComplaints t WHERE t.complaintId = :complaintId"),
    @NamedQuery(name = "TbComplaints.findByPriorityValue", query = "SELECT t FROM TbComplaints t WHERE t.priorityValue = :priorityValue")})
public class TbComplaints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Complaint_Id", nullable = false, length = 10)
    private String complaintId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Problem_Content", nullable = false, length = 1073741823)
    private String problemContent;
    @Lob
    @Column(name = "Image", length = 1073741823)
    private String image;
    @Basic(optional = false)
    @Column(name = "Priority_Value", nullable = false)
    private int priorityValue;
    @JoinColumn(name = "Employee_Id", referencedColumnName = "Staff_Id", nullable = false)
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs;
    @JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id", nullable = false)
    @ManyToOne(optional = false)
    private TbCategories tbCategories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbComplaints")
    private Collection<TbAssignTasks> tbAssignTasksCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbComplaints")
    private Collection<LastestModifyDate> lastestModifyDateCollection;

    public TbComplaints() {
    }

    public TbComplaints(String complaintId) {
        this.complaintId = complaintId;
    }

    public TbComplaints(String complaintId, String problemContent, int priorityValue) {
        this.complaintId = complaintId;
        this.problemContent = problemContent;
        this.priorityValue = priorityValue;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public TbStaffs getTbStaffs() {
        return tbStaffs;
    }

    public void setTbStaffs(TbStaffs tbStaffs) {
        this.tbStaffs = tbStaffs;
    }

    public TbCategories getTbCategories() {
        return tbCategories;
    }

    public void setTbCategories(TbCategories tbCategories) {
        this.tbCategories = tbCategories;
    }

    public Collection<TbAssignTasks> getTbAssignTasksCollection() {
        return tbAssignTasksCollection;
    }

    public void setTbAssignTasksCollection(Collection<TbAssignTasks> tbAssignTasksCollection) {
        this.tbAssignTasksCollection = tbAssignTasksCollection;
    }

    public Collection<LastestModifyDate> getLastestModifyDateCollection() {
        return lastestModifyDateCollection;
    }

    public void setLastestModifyDateCollection(Collection<LastestModifyDate> lastestModifyDateCollection) {
        this.lastestModifyDateCollection = lastestModifyDateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintId != null ? complaintId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbComplaints)) {
            return false;
        }
        TbComplaints other = (TbComplaints) object;
        if ((this.complaintId == null && other.complaintId != null) || (this.complaintId != null && !this.complaintId.equals(other.complaintId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbComplaints[complaintId=" + complaintId + "]";
    }

}
