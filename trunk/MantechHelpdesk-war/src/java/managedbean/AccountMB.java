/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbAccounts;
import entity.TbDepartments;
import entity.TbRoles;
import entity.TbStaffs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbRolesFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;
import util.MD5;

/**
 *
 * @author khuongqn
 */
@ManagedBean
@RequestScoped
public class AccountMB {

    @EJB
    private TbRolesFacadeLocal tbRolesFacade;
    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    String name;
    String password;
    TbAccounts acc;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;// = request.getSession();
    String login_label;
    Collection<TbAccounts> listAcc;
    private static ArrayList<Account> listAccount = null;
    String departId = "";//="Depar00001";
    TbDepartments depart;
    Collection<TbDepartments> deplist;
    TbRoles role;
    TbRoles role_edit;
    String user_online;
    String context_path;
    String role_online;
    String title;
    String login_menu;

    public TbRoles getRole_edit() {
        return role_edit;
    }

    public void setRole_edit(TbRoles role_edit) {
        this.role_edit = role_edit;
    }

    /*
     * Get role_online from session
     */
    public String getRole_online() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if (request.getSession().getAttribute("role") != null) {
            return request.getSession().getAttribute("role").toString();
        } else {
            return "none";
        }
    }

    /*
     * Set role_online
     */
    public void setRole_online(String role_online) {
        this.role_online = role_online;
    }

    public String getContext_path() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    public void setContext_path(String context_path) {
        this.context_path = context_path;
    }

    public String getUser_online() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if (request.getSession().getAttribute("username_online") != null) {
            return request.getSession().getAttribute("username_online").toString() + " is online";
        } else {
            return "anonymous is online";
        }
    }

    public void setUser_online(String user_online) {
        this.user_online = user_online;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public ArrayList<Account> getListAccount() {
        if (listAccount == null) {

            listAccount = new ArrayList<Account>();
            listAcc = getListAcc();

            if (listAcc != null) {

                for (TbAccounts a : listAcc) {

                    //  System.out.println("da in sert");
                    listAccount.add(new Account(a));
                }
            }
            return listAccount;

        } else {

            return listAccount;
        }
    }

    public Collection<TbDepartments> getDeplist() {

        return tbDepartmentsFacade.findAll();
    }

    public void setDeplist(Collection<TbDepartments> deplist) {
        this.deplist = deplist;
    }

    public TbDepartments getDepart() {
        return depart;
    }

    public void setDepart(TbDepartments depart) {
        this.depart = depart;
    }

    /*
     * Get list TbAccounts from database and return Collection
     */
    public Collection<TbAccounts> getListAcc() {

        //System.out.println("name depart " + departId);

        depart.setDepartmentId(departId);
        Collection<TbStaffs> l;
        ArrayList<TbAccounts> la = new ArrayList<TbAccounts>();
        l = tbStaffsFacade.searchStaffFromDepart(depart);
        if (l != null) {
            //System.out.println("leng l=" + l.size());
            int i = 1;
            for (TbStaffs st : l) {

                TbAccounts tbacc = new TbAccounts();
                tbacc = tbAccountsFacade.searchDepartment(st);

                if (tbacc != null) {
                    la.add(tbacc);
                    //System.out.println("xong thu " + i);
                    i++;
                }
            }

        }
        return la;


    }

    public String searchDepart() {

        //System.out.println("da kich");
        listAccount = null;
        listAccount = getListAccount();

        return null;
    }

    public void setListAcc(Collection<TbAccounts> listAcc) {
        this.listAcc = listAcc;
    }

    public TbRoles getRole() {
        return role;
    }

    public void setRole(TbRoles role) {
        this.role = role;
    }

    /*
     * Get login label from session
     */
    public String getLogin_label() {

        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        session = request.getSession();

        String lb = "";

        if (session != null) {
            //if user_online is null that is the mean don't login
            if (session.getAttribute("username_online") == null) {
                return "Login";
            } else {
                return "Logout";
            }

        } else {
            return "Login";
        }
    }

    public void setLogin_label(String login_label) {
        this.login_label = login_label;
    }

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

    public String getLogin_menu() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getSession().getAttribute("login_menu").toString();
    }

    public void setLogin_menu(String login_menu) {
        this.login_menu = login_menu;
    }

    public String getTitle() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        title = request.getParameter("title");
        //System.out.println(title);
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TbAccounts getAcc() {
        return acc;
    }

    public void setAcc(TbAccounts acc) {
        this.acc = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * Creates a new instance of AccountMB
     */
    public AccountMB() {
        acc = new TbAccounts();
        depart = new TbDepartments();
        role = new TbRoles();
        role_edit = new TbRoles();
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    }

    /*
     *Function to check username and password are correct
     * 
     */
    public String checkLogin() {
        MD5 md5 = new MD5();
        String passwordMd5 = md5.getMd5Digest(password);
        setAcc(tbAccountsFacade.checkUsernamePassword(name, passwordMd5));


        if (acc != null) {

            //if role is admin
            if (acc.getTbRoles().getRoleId().equals("Roles00003")) {
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../admin/AdminMenu.xhtml");

                session.setAttribute("login_label", "Logout");
                session.setAttribute("username_online", name);
                session.setAttribute("role", "Roles00003");
                return "../admin/ViewAllAccounts.xhtml?title=View All Accounts";
            }
            //if role is technician
            if (acc.getTbRoles().getRoleId().equals("Roles00002")) {
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../technician/Tenician_Menu.xhtml");
                // login_label = "Logout";
                session.setAttribute("login_label", "Logout");
                session.setAttribute("username_online", name);
                session.setAttribute("role", "Roles00002");
                return "../technician/ViewComplaintLog.xhtml?title=View Complaints";
            }
            //if role is employee
            if (acc.getTbRoles().getRoleId().equals("Roles00001")) {
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../employee/EmployeeMenu.xhtml");
                // login_label = "Logout";
                session.setAttribute("login_label", "Logout");
                session.setAttribute("username_online", name);
                session.setAttribute("role", "Roles00001");
                return "../employee/LodgeNewComplaint.xhtml?title=View My Complaint";
            }
            return  "/public/Fail.xhtml";

        } else {
            return  "/public/Fail.xhtml";
        }
    }

    /*
     * Logout system
     */
    public String logout() {
        try {
            response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server
            response.setHeader("Cache-Control", "private"); // HTTP 1.1
            response.setHeader("Cache-Control", "no-store"); // HTTP 1.1
            response.setHeader("Cache-Control", "max-stale=0"); // HTTP 1.1
            request.logout();
            request.getSession().invalidate();

            return ("/public/Home.xhtml");

        } catch (ServletException ex) {
            Logger.getLogger(AccountMB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /*
     *Function to save edition of account
     * 
     */
    public String saveAction(Account a) {

        //get all existing value but set "editable" to false

        a.setEditable(false);
        System.out.println("ten cua role vua nhap: " + role_edit.getRoleName());
        if (role_edit.getRoleId() != null) {
            a.ac.setTbRoles(tbRolesFacade.find(role_edit.getRoleId()));
        }
        tbAccountsFacade.edit(a.ac);

        tbStaffsFacade.edit(a.ac.getTbStaffs());

        //   }
        //return to current page
        return null;

    }
    /*
     *Function to set editabe avariable equal true order to edit
     * 
     */

    public String editAction(Account a) {
        a.setEditable(true);
        return null;
    }
    
    /*
     * Disable role of user(mean delete user)
     */

    public String unavailableAction(Account a) {

        if (tbAccountsFacade.unavailableAccount(a.ac.getAccountId()) == true) {
            //    JOptionPane.showConfirmDialog(null,"OK!");
            //System.out.println("ok da unavailal");
            listAccount = null;
            listAccount = getListAccount();
            return null;
        } else {

            return null;
        }
    }

    //Function to search with multi criterial
    //Class to help in editation
    public static class Account {

        TbAccounts ac;
        boolean editable;

        public TbAccounts getAc() {
            return ac;
        }

        public void setAc(TbAccounts ac) {
            this.ac = ac;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }

        public Account(TbAccounts ac) {
            this.ac = ac;

        }
    }
}
