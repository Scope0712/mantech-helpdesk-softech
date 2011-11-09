/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.ComplaintDetails;
import entity.TbComplaintLogs;
import entity.TbComplaintLogsPK;
import entity.TbComplaintStatus;
import entity.TbComplaints;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sessionbean.ComplaintDetailsFacadeLocal;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbComplaintLogsFacadeLocal;
import sessionbean.TbComplaintStatusFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;

/**
 *
 * @author THANH
 */
@ManagedBean
@RequestScoped
public class thAllComplaint {

    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    @EJB
    private TbComplaintLogsFacadeLocal tbComplaintLogsFacade;
    @EJB
    private TbComplaintStatusFacadeLocal tbComplaintStatusFacade;
    @EJB
    private ComplaintDetailsFacadeLocal complaintDetailsFacade;
    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;
    @EJB
    private TbComplaintsFacadeLocal tbComplaintsFacade;
    Collection<ComplaintDetails> ListComplaint;
    Collection<ComplaintDetails> ListPending;
    Collection<ComplaintDetails> ListSolving;
    Collection<ComplaintDetails> ListSolved;
    Collection<ComplaintDetails> ListNotSolved;
    private static ArrayList<Complaint> listCom = null;
    String employeeId;
    TbComplaintLogs log;

    public String getEmployeeId() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        employeeId=tbAccountsFacade.find(id).getTbStaffs().getStaffId();
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public TbComplaintLogs getLog() {
        return log;
    }

    public void setLog(TbComplaintLogs log) {
        this.log = log;
    }

    public Collection<ComplaintDetails> getListComplaint() {
        employeeId=getEmployeeId();
        return complaintDetailsFacade.findByEmployeeID(employeeId);
    }

    public void setListComplaint(Collection<ComplaintDetails> ListComplaint) {
        this.ListComplaint = ListComplaint;
    }

    public ArrayList<Complaint> getListCom() {
        listCom = null;
        ListPending = null;
        if (listCom == null) {
            listCom = new ArrayList<Complaint>();
            ListPending = getListPending();
            if (ListPending != null) {

                for (ComplaintDetails a : ListPending) {


                    listCom.add(new Complaint(a));
                }
            }
            return listCom;

        } else {

            return listCom;
        }
    }

    public static void setListCom(ArrayList<Complaint> listCom) {
        thAllComplaint.listCom = listCom;
    }

    public Collection<ComplaintDetails> getListNotSolved() {
        employeeId=getEmployeeId();
        return complaintDetailsFacade.findComplaintStatus(employeeId, "Statu00004");
    }

    public void setListNotSolved(Collection<ComplaintDetails> ListNotSolved) {
        this.ListNotSolved = ListNotSolved;
    }

    public Collection<ComplaintDetails> getListSolved() {
        employeeId=getEmployeeId();
        return complaintDetailsFacade.findComplaintStatus(employeeId, "Statu00003");
    }

    public void setListSolved(Collection<ComplaintDetails> ListSolved) {
        this.ListSolved = ListSolved;
    }

    public Collection<ComplaintDetails> getListSolving() {
        employeeId=getEmployeeId();
        return complaintDetailsFacade.findComplaintStatus(employeeId, "Statu00002");
    }

    public void setListSolving(Collection<ComplaintDetails> ListSolving) {
        this.ListSolving = ListSolving;
    }

    public Collection<ComplaintDetails> getListPending() {
        employeeId=getEmployeeId();
        return complaintDetailsFacade.findComplaintStatus(employeeId, "Statu00001");
    }

    public void setListPending(Collection<ComplaintDetails> ListPending) {
        this.ListPending = ListPending;
    }

    /** Creates a new instance of thAllComplaint */
    public thAllComplaint() {
        log = new TbComplaintLogs();
    }

    public String Resend(Complaint com) {
        com.setDisable(true);
        //receive TbComplaint Object
        TbComplaints cp = tbComplaintsFacade.find(com.complaint.getComplaintId());
        //receive TbComplaintStatus Object
        TbComplaintStatus status = tbComplaintStatusFacade.find(com.complaint.getStatusId());
        //inscrease resendNo
        int re = com.complaint.getResendNo() + 1;
        //receive today
        long current_time = System.currentTimeMillis();
        java.sql.Date today = new java.sql.Date(current_time);
        //create TbComplaintLogs Object
        TbComplaintLogsPK LogsPK = new TbComplaintLogsPK(com.complaint.getComplaintId(), today, com.complaint.getStatusId());
        //create TbComplaintLogs object
        TbComplaintLogs logs = new TbComplaintLogs();
        //set parameter
        logs.setTbComplaints(cp);
        logs.setTbComplaintStatus(status);
        logs.setResendNo(re);
        logs.setTbComplaintLogsPK(LogsPK);
        //create
        tbComplaintLogsFacade.create(logs);

        return "ComplaintPending";
    }

    public static class Complaint {

        ComplaintDetails complaint;
        boolean disable;

        public ComplaintDetails getComplaint() {
            return complaint;
        }

        public void setComplaint(ComplaintDetails complaint) {
            this.complaint = complaint;
        }

        public boolean isDisable() {
            if (complaint.getDuration() >= 3) {
                return false;
            }
            return true;
        }

        public void setDisable(boolean disable) {
            this.disable = disable;
        }

        public Complaint(ComplaintDetails com) {
            this.complaint = com;
        }
    }
}
