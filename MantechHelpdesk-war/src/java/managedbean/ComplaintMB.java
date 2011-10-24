/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbComplaints;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author tuyenbui
 */
@ManagedBean
@RequestScoped
public class ComplaintMB {
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;

    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;

    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;


    //private List<TbComplaints> cpList;

    /** Creates a new instance of ComplaintMB */
    public ComplaintMB() {
    }

    public List<TbComplaints> retrieveComplaints() {
        return tbComplaintsFacade.findAll();
        
    }
}
