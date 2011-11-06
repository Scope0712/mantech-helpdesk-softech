/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbComplaintLogs")
@NamedQueries({
    @NamedQuery(name = "TbComplaintLogs.findAll", query = "SELECT t FROM TbComplaintLogs t"),
    @NamedQuery(name = "TbComplaintLogs.findByComplaintId", query = "SELECT t FROM TbComplaintLogs t WHERE t.tbComplaintLogsPK.complaintId = :complaintId"),
    @NamedQuery(name = "TbComplaintLogs.findByDate", query = "SELECT t FROM TbComplaintLogs t WHERE t.tbComplaintLogsPK.date = :date"),
    @NamedQuery(name = "TbComplaintLogs.findByStatus", query = "SELECT t FROM TbComplaintLogs t WHERE t.tbComplaintLogsPK.status = :status"),
    @NamedQuery(name = "TbComplaintLogs.findByResendNo", query = "SELECT t FROM TbComplaintLogs t WHERE t.resendNo = :resendNo")})
public class TbComplaintLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbComplaintLogsPK tbComplaintLogsPK;
    @Basic(optional = false)
    @Column(name = "Resend_No")
    private int resendNo;
    @JoinColumn(name = "Status", referencedColumnName = "Status_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbComplaintStatus tbComplaintStatus;
    @JoinColumn(name = "Complaint_Id", referencedColumnName = "Complaint_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbComplaints tbComplaints;

    public TbComplaintLogs() {
    }

    public TbComplaintLogs(TbComplaintLogsPK tbComplaintLogsPK) {
        this.tbComplaintLogsPK = tbComplaintLogsPK;
    }

    public TbComplaintLogs(TbComplaintLogsPK tbComplaintLogsPK, int resendNo) {
        this.tbComplaintLogsPK = tbComplaintLogsPK;
        this.resendNo = resendNo;
    }

    public TbComplaintLogs(String complaintId, Date date, String status) {
        this.tbComplaintLogsPK = new TbComplaintLogsPK(complaintId, date, status);
    }

    public TbComplaintLogsPK getTbComplaintLogsPK() {
        return tbComplaintLogsPK;
    }

    public void setTbComplaintLogsPK(TbComplaintLogsPK tbComplaintLogsPK) {
        this.tbComplaintLogsPK = tbComplaintLogsPK;
    }

    public int getResendNo() {
        return resendNo;
    }

    public void setResendNo(int resendNo) {
        this.resendNo = resendNo;
    }

    public TbComplaintStatus getTbComplaintStatus() {
        return tbComplaintStatus;
    }

    public void setTbComplaintStatus(TbComplaintStatus tbComplaintStatus) {
        this.tbComplaintStatus = tbComplaintStatus;
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
        hash += (tbComplaintLogsPK != null ? tbComplaintLogsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbComplaintLogs)) {
            return false;
        }
        TbComplaintLogs other = (TbComplaintLogs) object;
        if ((this.tbComplaintLogsPK == null && other.tbComplaintLogsPK != null) || (this.tbComplaintLogsPK != null && !this.tbComplaintLogsPK.equals(other.tbComplaintLogsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbComplaintLogs[tbComplaintLogsPK=" + tbComplaintLogsPK + "]";
    }

}
