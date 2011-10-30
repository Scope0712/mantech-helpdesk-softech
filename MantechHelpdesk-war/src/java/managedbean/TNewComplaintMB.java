/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.ComplDetailAndCurrentStatus;
import entity.TbAssignTasks;
import entity.TbComplaintLogs;
import entity.TbComplaintLogsPK;
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
import sessionbean.TbComplaintLogsFacadeLocal;
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

    public ComplDetailAndCurrentStatus getNewComp() {
        return newComp;
    }

    public void setNewComp(ComplDetailAndCurrentStatus newComp) {
        this.newComp = newComp;
    }
    //private int complType;

    // HttpSession session;
    /** Creates a new instance of TNewComplaintMB */
    public TNewComplaintMB() {
        newComp = new ComplDetailAndCurrentStatus();
    }

    //get complaint need assigning base on complaint type
    public List<ComplDetailAndCurrentStatus> getNewCompList() {

//        if (complType == 0) {
//            this.newComplList = complDetailAndCurrentStatusFacade.findAllNeedAssign();
//        } else

        //lay complType tu session
        Integer complType = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("complType");
        if (complType != null) {
            if (complType == 1) {//assign for new complaint
                this.newComplList = complDetailAndCurrentStatusFacade.findNewCompls();
//            } else if (complType == 2) {//assign for resend complaint
//                this.newComplList = complDetailAndCurrentStatusFacade.findResendCompls();
            } else if (complType == 2) {//assign for unsolved complaint
                this.newComplList = complDetailAndCurrentStatusFacade.findByStatus("Statu00004");//display unsolved complaints
            }
        }
        return newComplList;
    }

    //event handler for changing complaint type
    public void complTypeChanged(ValueChangeEvent e) {
        int complType = Integer.parseInt(e.getNewValue().toString());
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("complType", complType);
    }

    public String showComplDetail(ComplDetailAndCurrentStatus compl) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("compl", compl);
        this.newComp = compl;
        return "DETAIL";
    }
    //Assign task
    @EJB
    private TbComplaintLogsFacadeLocal tbComplaintLogsFacade;
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
    private TbComplaintLogs log;
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
        newComp = (ComplDetailAndCurrentStatus) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("compl");
        if (newComp != null) {
            System.out.println(newComp.getComplaintid());
            comp = tbComplaintsFacade.find(newComp.getComplaintid());
            task.setTbComplaints(comp);
            System.out.println("set compl ok");
        } else {
            System.out.println("newCompl null");
        }

        //set create date
        task.setCreateDate(new Date());
        System.out.println("set date ok");

        //create task
        tbAssignTasksFacade.create(task);

        //in case of reassign for an unsolved task then change complaint status from unsolved(Statu00004) to pending(Statu00001)
        int ctype = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("complType");
        System.out.println("complaint type: " + ctype);
        if (ctype == 2) {
            log = new TbComplaintLogs(comp.getComplaintId(), new Date(), "Statu00001");
            System.out.println("Ghi log: complaint Id " + comp.getComplaintId());
            log.setResendNo(tbComplaintLogsFacade.findResendNo(comp.getComplaintId()));
            tbComplaintLogsFacade.create(log);
        }

    }

    public void technicianChanged(ValueChangeEvent e) {
        staffId = e.getNewValue().toString();
    }
}
