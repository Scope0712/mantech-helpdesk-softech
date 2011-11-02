/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import entity.TbComplaints;
import entity.TbDepartments;
import entity.TbStaffs;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbComplaintStatusFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author THANH
 */
@ManagedBean
@RequestScoped
public class NewComplaintBean {

    @EJB
    private TbComplaintStatusFacadeLocal tbComplaintStatusFacade;
    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;
    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;
    /** Creates a new instance of NewComplaintBean */
    TbCategories category;
    Collection<TbCategories> ListCategory;
    TbComplaints complaint;
    TbDepartments department;
    Collection<TbDepartments> ListDepartment;

    public Collection<TbDepartments> getListDepartment() {
        return tbDepartmentsFacade.findAll();
    }

    public void setListDepartment(Collection<TbDepartments> ListDepartment) {
        this.ListDepartment = ListDepartment;
    }

    public TbDepartments getDepartment() {
        return department;
    }

    public void setDepartment(TbDepartments department) {
        this.department = department;
    }

    public TbComplaints getComplaint() {
        return complaint;
    }

    public void setComplaint(TbComplaints complaint) {
        this.complaint = complaint;
    }

    public Collection<TbCategories> getListCategory() {
        return tbCategoriesFacade.findAll();
    }

    public void setListCategory(Collection<TbCategories> ListCategory) {
        this.ListCategory = ListCategory;
    }

    public TbCategories getCategory() {
        return category;
    }

    public void setCategory(TbCategories category) {
        this.category = category;
    }

    public NewComplaintBean() {
        category = new TbCategories();
        complaint = new TbComplaints();
        department = new TbDepartments();

    }

    public String NewComplaint() {

        try {

            //create new complaint
            complaint.setTbCategories(category);
            TbStaffs employee = tbStaffsFacade.find("Staff00001");
            complaint.setTbStaffs(employee);
            TbDepartments a = tbDepartmentsFacade.find(department.getDepartmentId());
            TbCategories b = tbCategoriesFacade.find(category.getCategoryId());
            int priority = a.getPriority() + b.getPriority();
            complaint.setPriorityValue(priority);
            tbComplaintsFacade.create(complaint);
        } catch (Exception ex) {
            Logger.getLogger(NewComplaintBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "/Result?a=xong";
    }
}
