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
 * @author tuyenbui
 */
@Entity
@Table(name = "report")
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByComplaintId", query = "SELECT r FROM Report r WHERE r.complaintId = :complaintId"),
    @NamedQuery(name = "Report.findByCategoryid", query = "SELECT r FROM Report r WHERE r.categoryid = :categoryid"),
    @NamedQuery(name = "Report.findByResendNo", query = "SELECT r FROM Report r WHERE r.resendNo = :resendNo"),
    @NamedQuery(name = "Report.findByLodgingDate", query = "SELECT r FROM Report r WHERE r.lodgingDate = :lodgingDate"),
    @NamedQuery(name = "Report.findByAssigningDate", query = "SELECT r FROM Report r WHERE r.assigningDate = :assigningDate"),
    @NamedQuery(name = "Report.findByLatestModifyDate", query = "SELECT r FROM Report r WHERE r.latestModifyDate = :latestModifyDate"),
    @NamedQuery(name = "Report.findBySolvingTime", query = "SELECT r FROM Report r WHERE r.solvingTime = :solvingTime")})
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "complaint_id")
    @Id
    private String complaintId;

    @Basic(optional = false)
    @Column(name = "Category_id")
    private String categoryid;

    @Basic(optional = false)
    @Column(name = "Resend_No")
    private int resendNo;

    @Column(name = "Lodging_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lodgingDate;

    @Column(name = "Assigning_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assigningDate;

    @Column(name = "Latest_Modify_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latestModifyDate;

    @Column(name = "Solving_Time")
    private Integer solvingTime;

    @JoinColumn(name = "Technician_Id", referencedColumnName = "Staff_Id")
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs;

    @JoinColumn(name = "Status", referencedColumnName = "Status_Id")
    @ManyToOne(optional = false)
    private TbComplaintStatus tbComplaintStatus;

    @JoinColumn(name = "Employee_Id", referencedColumnName = "Staff_Id")
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs1;

    @JoinColumn(name = "Department_Id", referencedColumnName = "Department_Id")
    @ManyToOne(optional = false)
    private TbDepartments tbDepartments;

    public Report() {
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public int getResendNo() {
        return resendNo;
    }

    public void setResendNo(int resendNo) {
        this.resendNo = resendNo;
    }

    public Date getLodgingDate() {
        return lodgingDate;
    }

    public void setLodgingDate(Date lodgingDate) {
        this.lodgingDate = lodgingDate;
    }

    public Date getAssigningDate() {
        return assigningDate;
    }

    public void setAssigningDate(Date assigningDate) {
        this.assigningDate = assigningDate;
    }

    public Date getLatestModifyDate() {
        return latestModifyDate;
    }

    public void setLatestModifyDate(Date latestModifyDate) {
        this.latestModifyDate = latestModifyDate;
    }

    public Integer getSolvingTime() {
        return solvingTime;
    }

    public void setSolvingTime(Integer solvingTime) {
        this.solvingTime = solvingTime;
    }

    public TbStaffs getTbStaffs() {
        return tbStaffs;
    }

    public void setTbStaffs(TbStaffs tbStaffs) {
        this.tbStaffs = tbStaffs;
    }

    public TbComplaintStatus getTbComplaintStatus() {
        return tbComplaintStatus;
    }

    public void setTbComplaintStatus(TbComplaintStatus tbComplaintStatus) {
        this.tbComplaintStatus = tbComplaintStatus;
    }

    public TbStaffs getTbStaffs1() {
        return tbStaffs1;
    }

    public void setTbStaffs1(TbStaffs tbStaffs1) {
        this.tbStaffs1 = tbStaffs1;
    }

    public TbDepartments getTbDepartments() {
        return tbDepartments;
    }

    public void setTbDepartments(TbDepartments tbDepartments) {
        this.tbDepartments = tbDepartments;
    }

}
