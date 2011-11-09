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
@Table(name = "CountComplaintByCategory")
@NamedQueries({
    @NamedQuery(name = "CountComplaintByCategory.findAll", query = "SELECT c FROM CountComplaintByCategory c"),
    @NamedQuery(name = "CountComplaintByCategory.findByNumberOfComplaint", query = "SELECT c FROM CountComplaintByCategory c WHERE c.numberOfComplaint = :numberOfComplaint")})
public class CountComplaintByCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Number_Of_Complaint")
    private Integer numberOfComplaint;

 //   @JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
   // @ManyToOne(optional = false)
    @Column(name = "Category_Id")
    @Id
    private String  categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public CountComplaintByCategory() {
    }

    public Integer getNumberOfComplaint() {
        return numberOfComplaint;
    }

    public void setNumberOfComplaint(Integer numberOfComplaint) {
        this.numberOfComplaint = numberOfComplaint;
    }

//    public TbCategories getTbCategories() {
//        return tbCategories;
//    }
//
//    public void setTbCategories(TbCategories tbCategories) {
//        this.tbCategories = tbCategories;
//    }
}
