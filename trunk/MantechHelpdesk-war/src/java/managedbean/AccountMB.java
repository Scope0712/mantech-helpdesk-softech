/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbAccounts;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
        acc= new TbAccounts();
    }

    public String checkLogin() {
        setAcc(tbAccountsFacade.checkUsernamePassword(name, password));
        if (acc != null) {
//            if(acc.getTbRoles().getRoleId().equals("Roles00001")){
//                return  "/admin/admin?faces-redirect=true";
//            }
            return "successful";
        } else {
            return "fail";
        }
    }
}
