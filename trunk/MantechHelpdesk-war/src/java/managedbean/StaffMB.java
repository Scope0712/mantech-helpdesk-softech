/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbRolesFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;
import entity.*;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khuongqn
 */
@ManagedBean
@RequestScoped
public class StaffMB {

    @EJB
    private TbRolesFacadeLocal tbRolesFacade;
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    TbAccounts acc;
    HttpServletRequest request;
    HttpServletResponse response;

    public TbAccounts getAcc() {
        return acc;
    }

    public void setAcc(TbAccounts acc) {
        this.acc = acc;
    }
    TbStaffs staff;
    TbDepartments depart;
    Collection<TbDepartments> departList;
    Collection<TbRoles> roletList;
    Collection<TbStaffs> staffList;

    public Collection<TbStaffs> getStaffList() {
        return staffList;
    }

    public void setStaffList(Collection<TbStaffs> staffList) {
        this.staffList = staffList;
    }

    public Collection<TbRoles> getRoletList() {
        return tbRolesFacade.findAll();
    }

    public void setRoletList(Collection<TbRoles> roletList) {
        this.roletList = roletList;
    }
    TbRoles role;

    public Collection<TbDepartments> getDepartList() {
        return tbDepartmentsFacade.findAll();
    }

    public TbRoles getRole() {
        return role;
    }

    public void setRole(TbRoles role) {
        this.role = role;
    }

    public void setDepartList(Collection<TbDepartments> departList) {
        this.departList = departList;
    }

    public TbDepartments getDepart() {
        return depart;
    }

    public void setDepart(TbDepartments depart) {
        this.depart = depart;
    }

    public TbStaffs getStaff() {

        return staff;
    }

    public void setStaff(TbStaffs staff) {
        this.staff = staff;
    }

    /** Creates a new instance of StaffMB */
    public StaffMB() {
        staff = new TbStaffs();
        role = new TbRoles();
        depart = new TbDepartments();
        acc = new TbAccounts();
    }

    public String CreateStaff() {

        staff.setStaffId("a");
        staff.setTbDepartments(depart);
        tbStaffsFacade.create(staff);
        
        acc.setAccountId("a");
        acc.setPassword("123456");
        acc.setStatus("Enable");
        acc.setTbRoles(role);
        acc.setTbStaffs(staff);
        tbAccountsFacade.create(acc);
       
        return "CreateAccount";
    }
   
   
}
