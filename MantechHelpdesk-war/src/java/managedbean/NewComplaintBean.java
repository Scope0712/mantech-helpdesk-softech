/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import entity.TbComplaints;
import entity.TbStaffs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author THANH
 */
@ManagedBean
@RequestScoped
public class NewComplaintBean {

    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;
    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;

    /** Creates a new instance of NewComplaintBean */
    public NewComplaintBean() {
    }
    String Categories;
    String Content;
    String Image;
    String EmployeeID;
    int Priority;

    public String getCategories() {
        return Categories;
    }

    public void setCategories(String Categories) {
        this.Categories = Categories;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public String NewComplaint() {
        
            try {
                TbComplaints complaint = new TbComplaints();
                complaint.setProblemContent(Content);
                complaint.setImage(null);
                TbCategories ca = tbCategoriesFacade.find(Categories);
                complaint.setTbCategories(ca);
                TbStaffs employee = tbStaffsFacade.find("Staff00001");
                complaint.setTbStaffs(employee);
                complaint.setPriorityValue(2);
                tbComplaintsFacade.create(complaint);
            } catch (Exception ex) {
                Logger.getLogger(NewComplaintBean.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        return "/Home";
    }
}
