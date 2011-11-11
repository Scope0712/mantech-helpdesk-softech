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
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbComplaintStatusFacadeLocal;
import sessionbean.TbComplaintsFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

import java.util.Date;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 *
 * @author THANH
 */
@ManagedBean
@RequestScoped
public class NewComplaintBean {

    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
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
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    }

    public String NewComplaint() {
        if (complaint.getProblemContent().equals("")) {
            status = "Please input data in content";
        } else {
            try {
                //receive AccountId from session
                HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                String id = (String) sessionuser.getAttribute("username_online");
                //set category
                complaint.setTbCategories(category);
                //set TbStaffs
                TbStaffs employee = tbAccountsFacade.find(id).getTbStaffs();
                complaint.setTbStaffs(employee);
                //set priority value
                TbDepartments a = employee.getTbDepartments();
                TbCategories b = tbCategoriesFacade.find(category.getCategoryId());
                int priority = a.getPriority() + b.getPriority();
                complaint.setPriorityValue(priority);
                //create new complaint
                tbComplaintsFacade.create(complaint);

                //send complaint to vtthanh306@gmail.com
                String to = "vtthanh306@gmail.com";
                String from = employee.getEmail();
                String Subject = "New Complaint from " + employee.getFirstName();
                String pass = employee.getPasswordMail();
                // Smtp Address of Mail Server here I am using Gmail
                String host = "smtp.gmail.com";
                //Properties file contains host details
                java.util.Properties props = System.getProperties();
                props.put("mail.smtp.user", from);
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
                Session session = Session.getInstance(props, new util.JavaMail(from, pass));
                // Instantiatee a message
                Message msg = new MimeMessage(session);
                //Set message attributes
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(Subject);
                msg.setSentDate(new Date());
                // Set message content
                String message = "";
                message += "DepartmentName: " + a.getDepartmentName() + "\n";
                message += "Category Name:    " + b.getCategoryName() + "\n";
                message += "Content:  " + complaint.getProblemContent() + "\n";
                message += "Priority Value:  " + complaint.getPriorityValue();
                msg.setText(message);
                //Send the message
                Transport.send(msg);

                status = "Complaint has been successfully send to " + to;
            } catch (Exception ex) {
                Logger.getLogger(NewComplaintBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "LodgeNewComplaint";
    }
}
