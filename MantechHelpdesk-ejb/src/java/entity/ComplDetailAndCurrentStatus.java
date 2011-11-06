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
import javax.persistence.Lob;
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
@Table(name = "Compl_Detail_And_Current_Status")
@NamedQueries({
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findAll", query = "SELECT c FROM ComplDetailAndCurrentStatus c"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByComplaintid", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.complaintid = :complaintid"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByEmployeeid", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.employeeid = :employeeid"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByCategoryId", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByPriorityValue", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.priorityValue = :priorityValue"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByLodgingDate", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.lodgingDate = :lodgingDate"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByStatus", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = :status"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByResendNo", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.resendNo = :resendNo")})
public class ComplDetailAndCurrentStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Complaint_id")
    @Id
    private String complaintid;
    @Basic(optional = false)
    @Column(name = "Employee_id")
    private String employeeid;
    @Basic(optional = false)
    @Column(name = "Category_Id")
    private String categoryId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Problem_content")
    private String problemcontent;
    @Basic(optional = false)
    @Column(name = "Priority_Value")
    private int priorityValue;
    @Column(name = "Lodging_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lodgingDate;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "resend_no")
    private int resendNo;

    public ComplDetailAndCurrentStatus() {
    }

    public String getComplaintid() {
        return complaintid;
    }

    public void setComplaintid(String complaintid) {
        this.complaintid = complaintid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProblemcontent() {
        return problemcontent;
    }

    public void setProblemcontent(String problemcontent) {
        this.problemcontent = problemcontent;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
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
