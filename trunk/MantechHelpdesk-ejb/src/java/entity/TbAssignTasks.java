/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbAssignTasks")
@NamedQueries({
    @NamedQuery(name = "TbAssignTasks.findAll", query = "SELECT t FROM TbAssignTasks t"),
    @NamedQuery(name = "TbAssignTasks.findByTaskId", query = "SELECT t FROM TbAssignTasks t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "TbAssignTasks.findByCreateDate", query = "SELECT t FROM TbAssignTasks t WHERE t.createDate = :createDate"),
    //view assign task of technician
     @NamedQuery(name = "TbAssignTasks.findTask", query = "SELECT t FROM TbAssignTasks t WHERE t.tbStaffs = :tbStaffs"),
})
public class TbAssignTasks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Task_Id")
    private String taskId;
    @Basic(optional = false)
    @Column(name = "Create_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinTable(name = "tbAssignTaskDetails", joinColumns = {
        @JoinColumn(name = "Task_Id", referencedColumnName = "Task_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Technician_Id", referencedColumnName = "Staff_Id")})
    @ManyToMany
    private Collection<TbStaffs> tbStaffsCollection;
    @JoinColumn(name = "Technician_Id", referencedColumnName = "Staff_Id")
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs;
    @JoinColumn(name = "Admin_Id", referencedColumnName = "Staff_Id")
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs1;
    @JoinColumn(name = "Complaint_Id", referencedColumnName = "Complaint_Id")
    @ManyToOne(optional = false)
    private TbComplaints tbComplaints;

    public TbAssignTasks() {
    }

    public TbAssignTasks(String taskId) {
        this.taskId = taskId;
    }

    public TbAssignTasks(String taskId, Date createDate) {
        this.taskId = taskId;
        this.createDate = createDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Collection<TbStaffs> getTbStaffsCollection() {
        return tbStaffsCollection;
    }

    public void setTbStaffsCollection(Collection<TbStaffs> tbStaffsCollection) {
        this.tbStaffsCollection = tbStaffsCollection;
    }

    public TbStaffs getTbStaffs() {
        return tbStaffs;
    }

    public void setTbStaffs(TbStaffs tbStaffs) {
        this.tbStaffs = tbStaffs;
    }

    public TbStaffs getTbStaffs1() {
        return tbStaffs1;
    }

    public void setTbStaffs1(TbStaffs tbStaffs1) {
        this.tbStaffs1 = tbStaffs1;
    }

    public TbComplaints getTbComplaints() {
        return tbComplaints;
    }

    public void setTbComplaints(TbComplaints tbComplaints) {
        this.tbComplaints = tbComplaints;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAssignTasks)) {
            return false;
        }
        TbAssignTasks other = (TbAssignTasks) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbAssignTasks[taskId=" + taskId + "]";
    }

}
