/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbAccounts;
import entity.TbDepartments;
import entity.TbStaffs;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.MD5;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author THANH
 */
@ManagedBean
@RequestScoped
public class Profile {

    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    TbStaffs staff;
    TbDepartments department;
    String newpass;
    String confirmpass;
    String birthday;
    String oldpass;
    String status;
    String address;
    String phone;
    String email;
    String marry;

    public String getAddress() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        staff = account.getTbStaffs();
        return staff.getAddress();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        staff = account.getTbStaffs();
        return staff.getEmail();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        staff = account.getTbStaffs();
        return staff.getPhoneNo();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMarry() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        staff = account.getTbStaffs();
        return staff.getMaritalStatus();
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBirthday() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        TbStaffs staff2 = tbStaffsFacade.find(account.getTbStaffs().getStaffId());
        Date utilDate = new Date(staff2.getDateOfBirth().getTime());
        birthday = formatter.format(utilDate);
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public TbDepartments getDepartment() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        //TbStaffs staff2=tbStaffsFacade.find(account.getTbStaffs().getStaffId());
        department = tbDepartmentsFacade.find(account.getTbStaffs().getTbDepartments().getDepartmentId());
        return department;
    }

    public void setDepartment(TbDepartments department) {
        this.department = department;
    }

    public TbStaffs getStaff() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        //staff=tbStaffsFacade.find(account.getTbStaffs().getStaffId());
        staff = account.getTbStaffs();
        return staff;
    }

    public void setStaff(TbStaffs staff) {
        this.staff = staff;
    }

    /** Creates a new instance of Profile */
    public Profile() {
    }

    public String EditProfile() {
        try {
            HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            String id = (String) sessionuser.getAttribute("username_online");
            TbAccounts account = tbAccountsFacade.find(id);
            //format date string to java.sql.Date
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            date = formatter.parse(birthday);
            System.out.println("1" + date);
            java.sql.Date birth = new java.sql.Date(date.getTime());
            staff.setDateOfBirth(birth);
            //update password of email
            MD5 m = new MD5();
            if (account.getPassword().equals(m.getMd5Digest(oldpass)) && !oldpass.equals("")) {
                if (newpass.equals(confirmpass)) {
                    staff.setPasswordMail(m.getMd5Digest(newpass));

                } else {
                    status = "new password not match confirm password";
                }
            } else {
                status = "password of mail not corect";
            }
            //set values of staff
            staff.setMaritalStatus(marry);
            staff.setAddress(address);
            staff.setPhoneNo(phone);
            staff.setEmail(email);
            setStaff(staff);
            //update staff
            tbStaffsFacade.edit(staff);
            status = "Update sucessful";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            status = "Update fail";
        }


        return "Profile";
    }
}
