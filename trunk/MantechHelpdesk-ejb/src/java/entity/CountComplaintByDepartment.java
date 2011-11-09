/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CountComplaintByDepartment")
@NamedQueries({
    @NamedQuery(name = "CountComplaintByDepartment.findAll", query = "SELECT c FROM CountComplaintByDepartment c"),
    @NamedQuery(name = "CountComplaintByDepartment.findByNumberOfComplaint", query = "SELECT c FROM CountComplaintByDepartment c WHERE c.numberOfComplaint = :numberOfComplaint")})
public class CountComplaintByDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Number_Of_Complaint")   
    private Integer numberOfComplaint;

    @Column(name="Department_Id")
    @Id
//    @JoinColumn(name = "Department_Id", referencedColumnName = "Department_Id")
//    @ManyToOne(optional = false)
    private String departmentId;

    public CountComplaintByDepartment() {
    }

    public Integer getNumberOfComplaint() {
        return numberOfComplaint;
    }

    public void setNumberOfComplaint(Integer numberOfComplaint) {
        this.numberOfComplaint = numberOfComplaint;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }


//    public TbDepartments getTbDepartments() {
//        return tbDepartments;
//    }
//
//    public void setTbDepartments(TbDepartments tbDepartments) {
//        this.tbDepartments = tbDepartments;
//    }

}
