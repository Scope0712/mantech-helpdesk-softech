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
@Table(name = "report")
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByComplaintId", query = "SELECT r FROM Report r WHERE r.complaintId = :complaintId"),
    @NamedQuery(name = "Report.findByCategoryid", query = "SELECT r FROM Report r WHERE r.categoryid = :categoryid"),
    @NamedQuery(name = "Report.findByResendNo", query = "SELECT r FROM Report r WHERE r.resendNo = :resendNo"),
    @NamedQuery(name = "Report.findByLodgingDate", query = "SELECT r FROM Report r WHERE r.lodgingDate = :lodgingDate"),
    @NamedQuery(name = "Report.findByAssigningDate", query = "SELECT r FROM Report r WHERE r.assigningDate = :assigningDate"),
    @NamedQuery(name = "Report.findByLatestModifyDate", query = "SELECT r FROM Report r WHERE r.latestModifyDate = :latestModifyDate"),
    //---
    @NamedQuery(name = "Report.findByEmployeeId", query = "SELECT r FROM Report r WHERE r.employeeid = :employeeid"),
    @NamedQuery(name = "Report.findByTechnicianId", query = "SELECT r FROM Report r WHERE r.technicianid = :technicianid"),
    @NamedQuery(name = "Report.findByStatus", query = "SELECT r FROM Report r WHERE r.status = :status"),
    @NamedQuery(name = "Report.findByDepartmentId", query = "SELECT r FROM Report r WHERE r.departmentid = :departmentid"),

    //---
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
    //----------------
    //@Basic(optional = false)
    @Column(name = "Employee_id")
    private String employeeid;

    @Basic(optional = false)
    @Column(name = "Department_Id")
    private String departmentid;

    //@Basic(optional = false)
    @Column(name = "Technician_id")
    private String technicianid;

    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
//--------------------------

    public Report() {
    }

    //------------------------------
    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTechnicianid() {
        return technicianid;
    }

    public void setTechnician_id(String technicianid) {
        this.technicianid = technicianid;
    }
    //------------------------------

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

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }


}
