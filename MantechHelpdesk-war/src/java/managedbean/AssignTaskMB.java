/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbAccounts;
import entity.TbAssignTasks;
import entity.TbComplaintLogs;
import entity.TbComplaintStatus;
import entity.TbStaffs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbAssignTasksFacadeLocal;
import javax.servlet.http.HttpSession;
import sessionbean.TbAccountsFacade;
import sessionbean.TbComplaintLogsFacadeLocal;
import sessionbean.TbStaffsFacade;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author khuongqn
 */
@ManagedBean
@RequestScoped
public class AssignTaskMB {
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    @EJB
    private TbComplaintLogsFacadeLocal tbComplaintLogsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;

    @EJB
    private TbAssignTasksFacadeLocal tbAssignTasksFacade;
    TbComplaintStatus status;

    /** Creates a new instance of AssignTaskMB */
    Collection<TbAssignTasks> listAssginTask;
    private static ArrayList<AssignTask> listATL = null;

    public TbComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(TbComplaintStatus status) {
        this.status = status;
    }

  //  HttpSession session;
    public  ArrayList<AssignTask> getListATL() {
       // System.out.println("listATL="+listATL.size());
         if (listATL == null) {
            // System.out.println("da null roi");
            listATL = new ArrayList<AssignTask>();
            listAssginTask = getListAssginTask();
              System.out.println("listAssignTask="+listAssginTask.size());
            //  System.out.println("list acc co ko "+listAcc.size());
            //  System.out.println("length of listAcc ="+listAcc.size());
            if (listATL != null) {

                for (TbAssignTasks a : listAssginTask) {

                    //  System.out.println("da in sert");
                    listATL.add(new AssignTask(a));
                }
            }
            return listATL;

        } else {

            return listATL;
        }
    }


    public static void setListATL(ArrayList<AssignTask> listATL) {
        AssignTaskMB.listATL = listATL;
    }


    public Collection<TbAssignTasks> getListAssginTask() {
        HttpSession  session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
       TbAccounts ac= tbAccountsFacade.find(session.getAttribute("username_online"));
        System.out.println(ac.getTbStaffs().getStaffId());

        return tbAssignTasksFacade.findTask(ac.getTbStaffs());
    }

    public void setListAssginTask(Collection<TbAssignTasks> listAssginTask) {
        this.listAssginTask = listAssginTask;
    }

    public String saveAction(AssignTask at) {

        //get all existing value but set "editable" to false
      //  for (AssignTask a : listATL) {
            at.setEditable(false);
            //   System.out.println(role.getRoleName());
            //   a.ac.setTbRoles(role);
           Collection<TbComplaintLogs> cmlog= at.at.getTbComplaints().getTbComplaintLogsCollection();
           //get resent number is max
            int resentno=0;
           for(TbComplaintLogs o:cmlog){

                if(o.getResendNo()>resentno) resentno=o.getResendNo();
           }
           TbComplaintLogs cl= new TbComplaintLogs();
           cl.setResendNo(resentno);
           cl.getTbComplaintLogsPK().setDate(new Date());
           cl.setTbComplaintStatus(status);
           tbComplaintLogsFacade.create(cl);
           

           // tbStaffsFacade.edit(a.at.getTbStaffs());

     //   }
        //return to current page
        return null;

    }
    //Function to set editabe avariable equal true order to edit

    public String editAction(AssignTask at) {
        at.setEditable(true);

        return null;
    }
    public AssignTaskMB() {
         status=new TbComplaintStatus();
    }
//This class is used to keep status of TbAssignTasks object
    public static class AssignTask {

        TbAssignTasks at;
        boolean editable;

        public TbAssignTasks getAt() {
            return at;
        }

        public void setAt(TbAssignTasks at) {
            this.at = at;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }

        public AssignTask(TbAssignTasks at) {
            this.at = at;
        }
    }
}
