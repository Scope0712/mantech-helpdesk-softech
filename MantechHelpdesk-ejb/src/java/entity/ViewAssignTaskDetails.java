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
 * @author dell
 */
@Entity
@Table(name = "ViewAssignTaskDetails")
@NamedQueries({
    @NamedQuery(name = "ViewAssignTaskDetails.findAll", query = "SELECT v FROM ViewAssignTaskDetails v"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByTechnicianId", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.technicianId = :technicianId"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByCategoryName", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.categoryName = :categoryName"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByComplaintId", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.complaintId = :complaintId"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByFullName", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.fullName = :fullName"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByProblemContent", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.problemContent = :problemContent"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByImage", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.image = :image"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByDepartmentName", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.departmentName = :departmentName"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByPriorityValue", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.priorityValue = :priorityValue"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByDate", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.date = :date"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByResendno", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.resendno = :resendno"),
    @NamedQuery(name = "ViewAssignTaskDetails.findByStatusName", query = "SELECT v FROM ViewAssignTaskDetails v WHERE v.statusName = :statusName")})
public class ViewAssignTaskDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Technician_Id")
    private String technicianId;
    @Basic(optional = false)
    @Column(name = "Category_Name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "Complaint_Id")
    @Id
    private String complaintId;
    @Basic(optional = false)
   
    @Column(name = "Problem_Content")
    private String problemContent;

    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @Column(name = "Full_Name")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "Department_Name")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "Priority_Value")
    private int priorityValue;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "resendno")
    private Integer resendno;
    @Basic(optional = false)
    @Column(name = "Status_Name")
    private String statusName;

    public ViewAssignTaskDetails() {
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public Integer getResendno() {
        return resendno;
    }

    public void setResendno(Integer resendno) {
        this.resendno = resendno;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}
