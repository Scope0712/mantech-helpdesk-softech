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
@Table(name = "CountComplaintByTechnician")
@NamedQueries({
    @NamedQuery(name = "CountComplaintByTechnician.findAll", query = "SELECT c FROM CountComplaintByTechnician c"),
    @NamedQuery(name = "CountComplaintByTechnician.findByNumberOfComplaint", query = "SELECT c FROM CountComplaintByTechnician c WHERE c.numberOfComplaint = :numberOfComplaint")})
public class CountComplaintByTechnician implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Number_Of_Complaint")
//    @Id
    private Integer numberOfComplaint;
//     @JoinColumn(name = "Technician_Id", referencedColumnName = "Staff_Id")
//    @ManyToOne(optional = false)
//    private TbStaffs tbStaffs;
    @Column(name = "Technician_Id")
    @Id
    private String technicianId;

    public CountComplaintByTechnician() {
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public Integer getNumberOfComplaint() {
        return numberOfComplaint;
    }

    public void setNumberOfComplaint(Integer numberOfComplaint) {
        this.numberOfComplaint = numberOfComplaint;
    }
//    public TbStaffs getTbStaffs() {
//        return tbStaffs;
//    }
//
//    public void setTbStaffs(TbStaffs tbStaffs) {
//        this.tbStaffs = tbStaffs;
//    }
}
