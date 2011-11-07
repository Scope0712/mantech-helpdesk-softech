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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Compl_Current_Assign", catalog = "MantechHelpdesk", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ComplCurrentAssign.findAll", query = "SELECT c FROM ComplCurrentAssign c"),
    @NamedQuery(name = "ComplCurrentAssign.findByComplaintid", query = "SELECT c FROM ComplCurrentAssign c WHERE c.complaintid = :complaintid"),
    @NamedQuery(name = "ComplCurrentAssign.findByAssigningDate", query = "SELECT c FROM ComplCurrentAssign c WHERE c.assigningDate = :assigningDate")})
public class ComplCurrentAssign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Complaint_id", nullable = false, length = 10)
    @Id
    private String complaintid;
    @Column(name = "Assigning_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assigningDate;
    @JoinColumn(name = "Technician_Id", referencedColumnName = "Staff_Id", nullable = false)
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs;

    public ComplCurrentAssign() {
    }

    public String getComplaintid() {
        return complaintid;
    }

    public void setComplaintid(String complaintid) {
        this.complaintid = complaintid;
    }

    public Date getAssigningDate() {
        return assigningDate;
    }

    public void setAssigningDate(Date assigningDate) {
        this.assigningDate = assigningDate;
    }

    public TbStaffs getTbStaffs() {
        return tbStaffs;
    }

    public void setTbStaffs(TbStaffs tbStaffs) {
        this.tbStaffs = tbStaffs;
    }

}
