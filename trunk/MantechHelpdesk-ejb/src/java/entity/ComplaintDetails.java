/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "ComplaintDetails")
@NamedQueries({
    @NamedQuery(name = "ComplaintDetails.findAll", query = "SELECT c FROM ComplaintDetails c"),
    @NamedQuery(name = "ComplaintDetails.findByComplaintId", query = "SELECT c FROM ComplaintDetails c WHERE c.complaintId = :complaintId"),
    @NamedQuery(name = "ComplaintDetails.findByEmployeeID", query = "SELECT c FROM ComplaintDetails c WHERE c.employeeID = :employeeID"),
    @NamedQuery(name = "ComplaintDetails.findByFirstName", query = "SELECT c FROM ComplaintDetails c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "ComplaintDetails.findByCategoryId", query = "SELECT c FROM ComplaintDetails c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "ComplaintDetails.findByCategoryName", query = "SELECT c FROM ComplaintDetails c WHERE c.categoryName = :categoryName"),
    @NamedQuery(name = "ComplaintDetails.findByDate", query = "SELECT c FROM ComplaintDetails c WHERE c.date = :date"),
    @NamedQuery(name = "ComplaintDetails.findByDuration", query = "SELECT c FROM ComplaintDetails c WHERE c.duration = :duration"),
    @NamedQuery(name = "ComplaintDetails.findByResendNo", query = "SELECT c FROM ComplaintDetails c WHERE c.resendNo = :resendNo"),
    @NamedQuery(name = "ComplaintDetails.findByStatusId", query = "SELECT c FROM ComplaintDetails c WHERE c.statusId = :statusId"),
    @NamedQuery(name = "ComplaintDetails.findByStatusName", query = "SELECT c FROM ComplaintDetails c WHERE c.statusName = :statusName")})
public class ComplaintDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Complaint_Id")
    @Id
    private String complaintId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Problem_Content")
    private String problemContent;
    @Lob
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @Column(name = "Employee_ID")
    private String employeeID;
    @Basic(optional = false)
    @Column(name = "First_Name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "Category_Id")
    private String categoryId;
    @Basic(optional = false)
    @Column(name = "Category_Name")
    private String categoryName;
    @Column(name = "Date")
    private String date;
    @Column(name = "Duration")
    private Integer duration;
    @Basic(optional = false)
    @Column(name = "Resend_No")
    private int resendNo;
    @Basic(optional = false)
    @Column(name = "Status_Id")
    private String statusId;
    @Basic(optional = false)
    @Column(name = "Status_Name")
    private String statusName;

    public ComplaintDetails() {
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public int getResendNo() {
        return resendNo;
    }

    public void setResendNo(int resendNo) {
        this.resendNo = resendNo;
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

}
