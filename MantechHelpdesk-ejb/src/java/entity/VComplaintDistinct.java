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
 * @author tuyenbui
 */
@Entity
@Table(name = "VComplaintDistinct")
@NamedQueries({
    @NamedQuery(name = "VComplaintDistinct.findAll", query = "SELECT v FROM VComplaintDistinct v"),
    @NamedQuery(name = "VComplaintDistinct.findByComplaintId", query = "SELECT v FROM VComplaintDistinct v WHERE v.complaintId = :complaintId"),
    @NamedQuery(name = "VComplaintDistinct.findByDate", query = "SELECT v FROM VComplaintDistinct v WHERE v.date = :date"),
    @NamedQuery(name = "VComplaintDistinct.findByResendno", query = "SELECT v FROM VComplaintDistinct v WHERE v.resendno = :resendno")})
public class VComplaintDistinct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "complaint_id")
    @Id
    private String complaintId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "resendno")
    private Integer resendno;

    public VComplaintDistinct() {
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

    public Integer getResendno() {
        return resendno;
    }

    public void setResendno(Integer resendno) {
        this.resendno = resendno;
    }

}
