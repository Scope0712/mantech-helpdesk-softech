/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.ComplDetailAndCurrentStatus;
import entity.TbAssignTasks;
import entity.TbComplaints;
import entity.TbStaffs;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import sessionbean.ComplDetailAndCurrentStatusFacadeLocal;
import sessionbean.TbAssignTasksFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author tuyenbui
 */
public class TNewComplaintMB {

    @EJB
    private ComplDetailAndCurrentStatusFacadeLocal complDetailAndCurrentStatusFacade;
    private List<ComplDetailAndCurrentStatus> newComplList;
    private ComplDetailAndCurrentStatus newComp;
    private int complType = 0;

   // HttpSession session;

    /** Creates a new instance of TNewComplaintMB */
    public TNewComplaintMB() {
        newComp = new ComplDetailAndCurrentStatus();
    }

    public ComplDetailAndCurrentStatus getNewComp() {
        return newComp;
    }

    public void setNewComp(ComplDetailAndCurrentStatus newComp) {
        this.newComp = newComp;
    }

    //get complaint need assigning base on complaint type
    public List<ComplDetailAndCurrentStatus> getNewCompList() {

        if (complType == 0) {
            this.newComplList = complDetailAndCurrentStatusFacade.findAllNeedAssign();
        } else if (complType == 1) {
            this.newComplList = complDetailAndCurrentStatusFacade.findNewCompls();
        } else if (complType == 2) {
            this.newComplList = complDetailAndCurrentStatusFacade.findResendCompls();
        } else if (complType == 3) {
            this.newComplList = complDetailAndCurrentStatusFacade.findByStatus("Statu00004");//display unsolved complaints
        }

        return newComplList;
    }

    //event handler for changing complaint type
    public void complTypeChanged(ValueChangeEvent e) {
        complType = Integer.parseInt(e.getNewValue().toString());
    }

    public String showComplDetail(ComplDetailAndCurrentStatus compl) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("compl",compl);
        this.newComp = compl;
        return "DETAIL";
    }
    //Assign task
    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    @EJB
    private TbAssignTasksFacadeLocal tbAssignTasksFacade;
    private TbAssignTasks task;
    private TbComplaints comp;
    private TbStaffs admin;
    private TbStaffs technician;
    private String staffId;

    public void createTask() {

        task = new TbAssignTasks("");//task id

        //tim admin dang login, o day gan luon, de sua sau 
        admin = tbStaffsFacade.find("Staff00001");
        task.setTbStaffs1(admin);
        System.out.println("set admin ok");

        //set technician
        technician = tbStaffsFacade.find(staffId);
        task.setTbStaffs(technician);
        System.out.println("set technician ok");

        //set complaint
        newComp = (ComplDetailAndCurrentStatus)((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("compl");
        if (newComp != null) {
            System.out.println(newComp.getComplaintid());
            task.setTbComplaints(tbComplaintsFacade.find(newComp.getComplaintid()));
            System.out.println("set compl ok");
        }else {
            System.out.println("newCompl null");
        }

        //set create date
        task.setCreateDate(new Date());
        System.out.println("set date ok");

        //create task
        tbAssignTasksFacade.create(task);
    }

    public void technicianChanged(ValueChangeEvent e) {
        staffId = e.getNewValue().toString();        
    }
}
