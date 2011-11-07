/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "Compl_Current_Status", catalog = "MantechHelpdesk", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ComplCurrentStatus.findAll", query = "SELECT c FROM ComplCurrentStatus c"),
    @NamedQuery(name = "ComplCurrentStatus.findByComplaintId", query = "SELECT c FROM ComplCurrentStatus c WHERE c.complaintId = :complaintId"),
    @NamedQuery(name = "ComplCurrentStatus.findByLodgingDate", query = "SELECT c FROM ComplCurrentStatus c WHERE c.lodgingDate = :lodgingDate"),
    @NamedQuery(name = "ComplCurrentStatus.findByStatus", query = "SELECT c FROM ComplCurrentStatus c WHERE c.status = :status"),
    @NamedQuery(name = "ComplCurrentStatus.findByResendNo", query = "SELECT c FROM ComplCurrentStatus c WHERE c.resendNo = :resendNo")})
public class ComplCurrentStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "complaint_id", nullable = false, length = 10)
    @Id
    private String complaintId;
    @Column(name = "Lodging_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lodgingDate;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false, length = 10)
    private String status;
    @Basic(optional = false)
    @Column(name = "Resend_No", nullable = false)
    private int resendNo;

    public ComplCurrentStatus() {
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public Date getLodgingDate() {
        return lodgingDate;
    }

    public void setLodgingDate(Date lodgingDate) {
        this.lodgingDate = lodgingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResendNo() {
        return resendNo;
    }

    public void setResendNo(int resendNo) {
        this.resendNo = resendNo;
    }

}
