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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author khuongqn
 */
@ManagedBean
@RequestScoped
public class AccountMB {

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
    String user_online = "a";

    public String getUser_online() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String user = request.getSession().getAttribute("username_online").toString();
        System.out.println(user);
        if (!user.equals(null)) {
            return user + "is online";
        } else {
            return "a";
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
            // System.out.println("da null roi");
            listAccount = new ArrayList<Account>();
            listAcc = getListAcc();
            //  System.out.println("list acc co ko "+listAcc.size());
            //  System.out.println("length of listAcc ="+listAcc.size());
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

    public Collection<TbAccounts> getListAcc() {

        // TbStaffs st=new TbStaffs();
        // depart.setDepartmentId("Depar00001");
        System.out.println("name depart " + departId);
        //listAccount=null;
        depart.setDepartmentId(departId);
        Collection<TbStaffs> l;
        ArrayList<TbAccounts> la = new ArrayList<TbAccounts>();
        l = tbStaffsFacade.searchStaffFromDepart(depart);
        if (l != null) {
            // System.out.println("leng l="+l.size());
            int i = 1;
            for (TbStaffs st : l) {
                //    System.out.println("length "+l.size());
                TbAccounts tbacc = new TbAccounts();
                tbacc = tbAccountsFacade.searchDepartment(st);
                //  System.out.println("tbacc "+i+": "+tbacc.getAccountId());
                if (tbacc != null) {
                    la.add(tbacc);
                    System.out.println("xong thu " + i);
                    i++;
                }
            }
            // staff.setTbDepartments(depart);
            //  acc.setTbStaffs(staff);
            // System.out.println("la="+la.size());
        }
        return la;
        //  return tbAccountsFacade.findAll();

    }

    public String searchDepart() {
        //  System.out.println("depart id="+depart.getDepartmentId());
        //  System.out.println("kich thuoc chinsh "+listAccount.size());
        System.out.println("da kich");
        listAccount = null;
        listAccount = getListAccount();
        // System.out.println(listAccount.size());
        //  listAccount=null;
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

//    public TbAccounts getNewacc() {
//
//        return tbAccountsFacade.findNewAccount();
//
//
//    }
//    public void setNewacc(TbAccounts newacc) {
//        this.newacc = newacc;
//    }
    public String getLogin_label() {

        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       session = request.getSession();
       // if (session.getAttribute("login_menu") != null) {
            //  System.out.println(request.getSession().getAttribute("login_menu").toString());
             return request.getSession().getAttribute("login_label").toString();
          //  return "Logout";
      //  } else {
        //    return "Login";
      //  }
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
    String title;
    String login_menu;

    public String getLogin_menu() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //  System.out.println(request.getSession().getAttribute("login_menu").toString());
        return request.getSession().getAttribute("login_menu").toString();
    }

    public void setLogin_menu(String login_menu) {
        this.login_menu = login_menu;
    }

    public String getTitle() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        title = request.getParameter("title");
        System.out.println(title);
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

    /** Creates a new instance of AccountMB */
    public AccountMB() {
        acc = new TbAccounts();
        depart = new TbDepartments();
        role = new TbRoles();
          session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        // session.setAttribute("login_menu", "../employee/EmployeeMenu.xhtml");
        //  login_label = "Logout";
         session.setAttribute("login_label", "Login");
    }
    //Function to check username and password are correct

    public String checkLogin() {
        setAcc(tbAccountsFacade.checkUsernamePassword(name, password));
        if (acc != null) {

            // request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            // request.login(name, password);

            if (acc.getTbRoles().getRoleId().equals("Roles00003")) {
                //  System.out.println(acc.getTbRoles().getRoleId() + ":" + acc.getTbRoles().getRoleName());
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../admin/AdminMenu.xhtml");
                // login_label = "Logout";
                session.setAttribute("login_label", "Logout");
                session.setAttribute("username_online", name);
                return "../admin/CreateAccount.xhtml?title=New Account";
            }
            if (acc.getTbRoles().getRoleId().equals("Roles00002")) {
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../technician/Tenician_Menu.xhtml");
                // login_label = "Logout";
                session.setAttribute("login_label", "Logout");
                session.setAttribute("username_online", name);
                return "../technician/ViewComplaintLog.xhtml?title=View Complaints";
            }
            if (acc.getTbRoles().getRoleId().equals("Roles00001")) {
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../employee/EmployeeMenu.xhtml");
                // login_label = "Logout";
                session.setAttribute("login_label", "Logout");
                session.setAttribute("username_online", name);
                return "../employee/LodgeNewComplaint.xhtml?title=View My Complaint";
            }
            return "/Home";
            // return "successful";

        } else {
            return "/Home";
        }
    }

//    public String logout() {
//        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        session.setAttribute("login_label", "Login");
//        session.setAttribute("username_online", "");
//        session.setAttribute("login_menu", "");
//        return null;
//    }

    //Function to save edition of account
    public String saveAction() {

        //get all existing value but set "editable" to false
        for (Account a : listAccount) {
            a.setEditable(false);
            //   System.out.println(role.getRoleName());
            //   a.ac.setTbRoles(role);
            tbAccountsFacade.edit(a.ac);

            tbStaffsFacade.edit(a.ac.getTbStaffs());

        }
        //return to current page
        return null;

    }
    //Function to set editabe avariable equal true order to edit

    public String editAction(Account a) {
        a.setEditable(true);
        return null;
    }

    public String unavailableAction(Account a) {

        if (tbAccountsFacade.unavailableAccount(a.ac.getAccountId()) == true) {
            //    JOptionPane.showConfirmDialog(null,"OK!");
            System.out.println("ok da unavailal");
            listAccount = null;
            listAccount = getListAccount();
            return null;
        } else {
            // JOptionPane.showConfirmDialog(null,"Not Unavailable!");
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
