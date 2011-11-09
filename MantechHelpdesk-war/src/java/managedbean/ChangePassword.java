/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbAccounts;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.MD5;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;

/**
 *
 * @author THANH
 */
@ManagedBean
@RequestScoped
public class ChangePassword {

    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    String newpassword;
    String confirmpassword;
    String password;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public ChangePassword() {
       
    }

    public String Change() {
        HttpSession sessionuser = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        String id = (String) sessionuser.getAttribute("username_online");
        TbAccounts account = tbAccountsFacade.find(id);
        System.out.println(password);
        System.out.println(account.getPassword());
        System.out.println(newpassword);
        System.out.println(confirmpassword);
        try {
            MD5 m = new MD5();

            if (account.getPassword().equals(m.getMd5Digest(password))) {
                System.out.println(account.getPassword());
                if (newpassword.equals(confirmpassword)) {

                    account.setPassword(m.getMd5Digest(newpassword));
                    tbAccountsFacade.edit(account);
                }else{
                    status="new password not match confirm password";
                    return "ChangePassword";
                }
            }else{
                status="password not corect";
                return "ChangePassword";
            }
            status="change password sucessful";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "/Fail";
        }
        return "ChangePassword";
        //return "/Result";
    }
}
