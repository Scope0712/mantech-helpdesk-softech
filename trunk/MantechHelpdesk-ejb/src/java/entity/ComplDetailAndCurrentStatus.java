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
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByDate", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.date = :date"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByStatus", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = :status"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findByResendNo", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.resendNo = :resendNo"),
    //tuyen
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findAllNeedAssign", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' or c.status = 'Statu00004'"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findNewCompls", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' and c.resendNo = 0"),
    @NamedQuery(name = "ComplDetailAndCurrentStatus.findResendCompls", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' and c.resendNo <> 0")})
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
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @Column(name = "resend_no")
    private Integer resendNo;

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

    public Integer getResendNo() {
        return resendNo;
    }

    public void setResendNo(Integer resendNo) {
        this.resendNo = resendNo;
    }
}
