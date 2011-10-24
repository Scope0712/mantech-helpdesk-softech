/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tuyenbui
 */
@Embeddable
public class TbComplaintLogsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Complaint_Id")
    private String complaintId;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;

    public TbComplaintLogsPK() {
    }

    public TbComplaintLogsPK(String complaintId, Date date, String status) {
        this.complaintId = complaintId;
        this.date = date;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintId != null ? complaintId.hashCode() : 0);
        hash += (date != null ? date.hashCode() : 0);
        hash += (status != null ? status.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbComplaintLogsPK)) {
            return false;
        }
        TbComplaintLogsPK other = (TbComplaintLogsPK) object;
        if ((this.complaintId == null && other.complaintId != null) || (this.complaintId != null && !this.complaintId.equals(other.complaintId))) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.status == null && other.status != null) || (this.status != null && !this.status.equals(other.status))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbComplaintLogsPK[complaintId=" + complaintId + ", date=" + date + ", status=" + status + "]";
    }

}
