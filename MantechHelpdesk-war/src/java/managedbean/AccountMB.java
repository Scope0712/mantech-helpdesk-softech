/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbAccounts;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.TbAccountsFacadeLocal;

/**
 *
 * @author khuongqn
 */
@ManagedBean
@RequestScoped
public class AccountMB {

    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    String name;
    String password;
    TbAccounts acc;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;// = request.getSession();
    String login_label="Login";

    public String getLogin_label() {
  
         return login_label;
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
      return  (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
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
        System.out.println(request.getSession().getAttribute("login_menu").toString());
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
    }

    public String checkLogin() throws IOException {
        setAcc(tbAccountsFacade.checkUsernamePassword(name, password));
        if (acc != null) {
            if (acc.getTbRoles().getRoleId().equals("Roles00003")) {
                System.out.println(acc.getTbRoles().getRoleId()+":"+acc.getTbRoles().getRoleName());
                session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../admin/AdminMenu.xhtml");
                login_label="Logout";
                return "../admin/CreateAccount.xhtml?title=New Account";
            }
            if (acc.getTbRoles().getRoleId().equals("Roles00002")) {
                session = (HttpSession)  FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../technician/TechnicianMenu.xhtml");
                 login_label="Logout";
                return "/technician/RetrieveComplaint.xhtml?title=View Complaints";
            }
            if (acc.getTbRoles().getRoleId().equals("Roles00001")) {
                session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login_menu", "../employee/EmployeeMenu.xhtml");
                 login_label="Logout";
                return "/employee/Employee_template.xhtml?title=View My Complaint";
            }
            return "/Home";
            // return "successful";
        } else {
            return "/Home";
        }
    }
}
