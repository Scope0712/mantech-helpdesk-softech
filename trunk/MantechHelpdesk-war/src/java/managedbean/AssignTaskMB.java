/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbComplaintLogs;
import entity.TbComplaintLogsPK;
import entity.TbComplaintStatus;
import entity.ViewAssignTaskDetails;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.TbComplaintLogsFacadeLocal;
import sessionbean.TbComplaintStatusFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.ViewAssignTaskDetailsFacadeLocal;

/**
 *
 * @author khuongqn
 */
@ManagedBean
@RequestScoped
public class AssignTaskMB {
    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;

    @EJB
    private TbComplaintStatusFacadeLocal tbComplaintStatusFacade;
    @EJB
    private ViewAssignTaskDetailsFacadeLocal viewAssignTaskDetailsFacade;
    Collection<ViewAssignTaskDetails> listViewAT;
    @EJB
    private TbComplaintLogsFacadeLocal tbComplaintLogsFacade;
    TbComplaintStatus status;
    Collection<TbComplaintStatus> listStatus;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
      public HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    public Collection<TbComplaintStatus> getListStatus() {
        return tbComplaintStatusFacade.findAll();
    }

    public void setListStatus(Collection<TbComplaintStatus> listStatus) {
        this.listStatus = listStatus;
    }
    /** Creates a new instance of AssignTaskMB */
    private static ArrayList<AssignTask> listATL = null;

    public TbComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(TbComplaintStatus status) {
        this.status = status;
    }

    //  HttpSession session;
    public ArrayList<AssignTask> getListATL() {
        // System.out.println("listATL="+listATL.size());
        if (listATL == null) {
            // System.out.println("da null roi");
            listATL = new ArrayList<AssignTask>();
            listViewAT = new ArrayList<ViewAssignTaskDetails>();
            System.out.println("sau khi da cho null" + listViewAT.size());

            listViewAT = viewAssignTaskDetailsFacade.findAll();
            System.out.println("da goi findall");
            System.out.println("listAssignTask=" + listViewAT.size());


            if (listViewAT != null) {

                for (ViewAssignTaskDetails a : listViewAT) {
                    System.out.println("status " + a.getStatusName());
                    //  System.out.println("da in sert");
                    listATL.add(new AssignTask(a));
                }
            }
            return listATL;

        } else {

            return listATL;
        }
    }

//    public static void setListATL(ArrayList<AssignTask> listATL) {
//        AssignTaskMB.listATL=null;
//        AssignTaskMB.listATL = listATL;
//    }

    public Collection<ViewAssignTaskDetails> getListViewAT() {
        System.out.println("chieu dai tai goc=" + viewAssignTaskDetailsFacade.findAll().size());
        return viewAssignTaskDetailsFacade.findAll();
    }

    public void setListViewAT(Collection<ViewAssignTaskDetails> listViewAT) {
        this.listViewAT = listViewAT;
    }

    public String saveAction(AssignTask at) {

        //get all existing value but set "editable" to false  
        
     //  SimpleDateFormat spl = new SimpleDateFormat("MM/dd/yyyy:hh:mm:ss a");

      //  String d = spl.format(new Date());
        TbComplaintLogs cl = new TbComplaintLogs(at.at.getComplaintId(), new Date(), status.getStatusId());
     //   System.out.println(d);
      //  cl.setTbComplaintLogsPK(new TbComplaintLogsPK().setDate(new Date(d)));
        cl.setTbComplaints(tbComplaintsFacade.find(at.at.getComplaintId()));
        cl.setResendNo(at.at.getResendno());
        cl.setTbComplaintStatus(tbComplaintStatusFacade.find(status.getStatusId()));
        System.out.println("da chon status "+cl.getTbComplaintStatus().getStatusName());
        tbComplaintLogsFacade.create(cl);
        at.at.setStatusName(cl.getTbComplaintStatus().getStatusName());
        viewAssignTaskDetailsFacade.edit(at.at);
        listATL = null;
        listViewAT=null;
        listATL = getListATL();

        at.setEditable(false);
        System.out.println("listATL " + listATL.size());

        //return to current page
        return "ViewComplaintLog";

    }
    //Function to set editabe avariable equal true order to edit

    public String editAction(AssignTask at) {
        at.setEditable(true);

        return null;
    }

    public AssignTaskMB() {
        status = new TbComplaintStatus();

    }

//This class is used to keep status of TbAssignTasks object
    public static class AssignTask {

        ViewAssignTaskDetails at;
        boolean editable;

        public ViewAssignTaskDetails getAt() {
            return at;
        }

        public void setAt(ViewAssignTaskDetails at) {
            this.at = at;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }

        public AssignTask(ViewAssignTaskDetails at) {
            this.at = at;
        }
    }
}
