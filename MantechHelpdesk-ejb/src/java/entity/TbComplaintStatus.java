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
@Table(name = "tbComplaintStatus")
@NamedQueries({
    @NamedQuery(name = "TbComplaintStatus.findAll", query = "SELECT t FROM TbComplaintStatus t"),
    @NamedQuery(name = "TbComplaintStatus.findByStatusId", query = "SELECT t FROM TbComplaintStatus t WHERE t.statusId = :statusId"),
    @NamedQuery(name = "TbComplaintStatus.findByStatusName", query = "SELECT t FROM TbComplaintStatus t WHERE t.statusName = :statusName")})
public class TbComplaintStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Status_Id")
    private String statusId;
    @Basic(optional = false)
    @Column(name = "Status_Name")
    private String statusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbComplaintStatus")
    private Collection<TbComplaintLogs> tbComplaintLogsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbComplaintStatus")
    private Collection<Report> reportCollection;

    public TbComplaintStatus() {
    }

    public TbComplaintStatus(String statusId) {
        this.statusId = statusId;
    }

    public TbComplaintStatus(String statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Collection<TbComplaintLogs> getTbComplaintLogsCollection() {
        return tbComplaintLogsCollection;
    }

    public void setTbComplaintLogsCollection(Collection<TbComplaintLogs> tbComplaintLogsCollection) {
        this.tbComplaintLogsCollection = tbComplaintLogsCollection;
    }

    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbComplaintStatus)) {
            return false;
        }
        TbComplaintStatus other = (TbComplaintStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbComplaintStatus[statusId=" + statusId + "]";
    }

}
