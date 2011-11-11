/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.ComplDetailAndCurrentStatus;
import entity.TbAssignTasks;
import entity.TbCategories;
import entity.TbComplaintLogs;
import entity.TbComplaints;
import entity.TbStaffs;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import sessionbean.ComplDetailAndCurrentStatusFacadeLocal;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbAssignTasksFacadeLocal;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbComplaintLogsFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author tuyenbui
 */
public class TNewComplaintMB {

//fields in page AssignComplaint.xhtml
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
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

    /** Creates a new instance of TNewComplaintMB */
    public TNewComplaintMB() {
        newComp = new ComplDetailAndCurrentStatus();
    }

    //get complaint need assigning
    //there are 2 type of complaints which need assigned to technician: new complaint and unsolved complaint (need assign for another technician)
    public List<ComplDetailAndCurrentStatus> getNewCompList() {
        //get complType from session
        Integer complType = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("complType");
        if (complType != null) {
            if (complType == 1) {//assign for new complaint
                this.newComplList = complDetailAndCurrentStatusFacade.findNewCompls();//get new complaints list
            } else if (complType == 2) {//assign for unsolved complaint
                this.newComplList = complDetailAndCurrentStatusFacade.findByStatus("Statu00004");//get unsolved complaints list
            }
        }
        return newComplList;
    }

    //event handler for changing complaint type
    //when user change complaint type in the interface, the new complaint type will be stored in session in order to getting later
    public void complTypeChanged(ValueChangeEvent e) {
        int complType = Integer.parseInt(e.getNewValue().toString());
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("complType", complType);
    }

    //when user click the "detail" link on the row of each complaint, control will move to the assigncomplDetail.xhtml
    public String showComplDetail(ComplDetailAndCurrentStatus compl) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("compl", compl);
        this.newComp = compl;
        return "DETAIL";
    }
    //field on page assigncomplDetail.xhtml
    @EJB
    private TbComplaintLogsFacadeLocal tbComplaintLogsFacade;
    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    @EJB
    private TbAssignTasksFacadeLocal tbAssignTasksFacade;
    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;
    private TbAssignTasks task;//a new task be assgined
    private TbComplaints comp;//complaint of the new task
    private TbStaffs admin;//admin who assign the task
    private TbStaffs technician;//technician who will be assgined the task
    private TbComplaintLogs log;//log will be written for the status of the complaint after assigning
    private String staffId;//selected technician in the technician combobox
    private boolean assignDisable;//disable the assign button or not
    private String categoryId; //selected category in category combobox
    private int priority;//selected priority in priority combobox

    public boolean isAssignDisable() {
        return assignDisable;
    }

    public void setAssignDisable(boolean assignDisable) {
        this.assignDisable = assignDisable;
    }

    public List<TbCategories> getCategoryList() {
        return (List<TbCategories>) tbCategoriesFacade.findAll();
    }

//    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String createTask() {
        System.out.println("goi create task");
        task = new TbAssignTasks("");//task id

        //get admin who is logging into the system to set for the task
        String accountId = (String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("username_online");
        admin = tbAccountsFacade.find(accountId).getTbStaffs();
        task.setTbStaffs1(admin);
        System.out.println("set admin ok");

        //get selected technician to set for the task
        technician = tbStaffsFacade.find(staffId);
        task.setTbStaffs(technician);
        System.out.println("set technician ok");

        //get complaint which is stored in session to set for the task
        newComp = (ComplDetailAndCurrentStatus) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("compl");
        if (newComp != null) {
            System.out.println(newComp.getComplaintid());
            comp = tbComplaintsFacade.find(newComp.getComplaintid());
            task.setTbComplaints(comp);
            System.out.println("set compl ok");
        } else {
            System.out.println("newCompl null");
        }

        //set create date for the task
        task.setCreateDate(new Date());
        System.out.println("set date ok");

        //create task
        tbAssignTasksFacade.create(task);

        //in case of reassign for an unsolved task then change complaint status from unsolved(Statu00004) to pending(Statu00001)
        int ctype = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("complType");
        System.out.println("complaint type: " + ctype);
        if (ctype == 2) {
            log = new TbComplaintLogs(comp.getComplaintId(), new Date(), "Statu00001");
            System.out.println("Write log: complaint Id " + comp.getComplaintId());
            log.setResendNo(tbComplaintLogsFacade.findResendNo(comp.getComplaintId()));
            tbComplaintLogsFacade.create(log);
        }

        //change category if admin select new category for this complaint
        if (!categoryId.equals("")) {
            comp.setTbCategories(new TbCategories(categoryId));
        }
        System.out.println("set category: " + categoryId);

        if (priority != 0) {
            //change priority if admin set new priority for this complaint
            comp.setPriorityValue(priority);
        }
        System.out.println("set priority: " + priority);


        tbComplaintsFacade.edit(comp);

        assignDisable = true;

        System.out.println("new comp:" + newComp.getPriorityValue());
        System.out.println("new comp:" + newComp.getCategoryId());

        complDetailAndCurrentStatusFacade.edit(newComp);
        return null;

    }

    public void technicianChanged(ValueChangeEvent e) {
        staffId = e.getNewValue().toString();
    }

    public void priorityChanged(ValueChangeEvent e) {
        System.out.println(e.getNewValue().toString());
        priority = Integer.parseInt(e.getNewValue().toString());
        newComp.setPriorityValue(priority);
        complDetailAndCurrentStatusFacade.edit(newComp);
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        session.setAttribute("compl", newComp);
    }

    public void categoryChanged(ValueChangeEvent e) {
        categoryId = e.getNewValue().toString();
        newComp.setCategoryId(categoryId);
        complDetailAndCurrentStatusFacade.edit(newComp);
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        session.setAttribute("compl", newComp);
    }

    public TbCategories findCategory(String cateid) {
        return tbCategoriesFacade.find(cateid);
    }
}
