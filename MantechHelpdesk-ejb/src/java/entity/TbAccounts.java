/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbAccounts")
@NamedQueries({
    @NamedQuery(name = "TbAccounts.findAll", query = "SELECT t FROM TbAccounts t"),
    @NamedQuery(name = "TbAccounts.findByAccountId", query = "SELECT t FROM TbAccounts t WHERE t.accountId = :accountId"),
    //Unavailable status of account
     @NamedQuery(name = "TbAccounts.UnavailableAccount", query = "UPDATE TbAccounts t SET t.status = 'Disable' WHERE t.accountId = :accountId"),
    //search account
    @NamedQuery(name = "TbAccounts.searchDepartment", query = "SELECT t FROM TbAccounts t WHERE t.tbStaffs = :staff and t.status='Enable'"),

    @NamedQuery(name = "TbAccounts.findByPassword", query = "SELECT t FROM TbAccounts t WHERE t.password = :password"),
    @NamedQuery(name = "TbAccounts.findByStatus", query = "SELECT t FROM TbAccounts t WHERE t.status = :status"),
    //the newest account
    @NamedQuery(name = "TbAccounts.findNewAccount", query = "SELECT t FROM TbAccounts t WHERE t.accountId = (SELECT max(o.accountId) from TbAccounts o)"),
    @NamedQuery(name = "TbAccounts.findByUsernameAndPassword", query = "SELECT t FROM TbAccounts t WHERE t.password = :password and t.accountId=:accountId and t.status='Enable'"),
    //tuyen
    @NamedQuery(name = "TbAccounts.findByRoleAndStatus", query = "SELECT t FROM TbAccounts t WHERE t.status =:status and t.tbRoles.roleId=:roleId")
})
public class TbAccounts implements Serializable {
  //  private boolean editAction;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Account_Id")
    private String accountId;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "Staff_Id", referencedColumnName = "Staff_Id")
    @ManyToOne
    private TbStaffs tbStaffs;
    @JoinColumn(name = "Role_Id", referencedColumnName = "Role_Id")
    @ManyToOne(optional = false)
    private TbRoles tbRoles;
   
//
//    public boolean isEditAction() {
//        return editAction;
//    }
//
//    public void setEditAction(boolean editAction) {
//        this.editAction = editAction;
//    }
//

    public TbAccounts() {
    }

    public TbAccounts(String accountId) {
        this.accountId = accountId;
    }

    public TbAccounts(String accountId, String password, String status) {
        this.accountId = accountId;
        this.password = password;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TbStaffs getTbStaffs() {
        return tbStaffs;
    }

    public void setTbStaffs(TbStaffs tbStaffs) {
        this.tbStaffs = tbStaffs;
    }

    public TbRoles getTbRoles() {
        return tbRoles;
    }

    public void setTbRoles(TbRoles tbRoles) {
        this.tbRoles = tbRoles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAccounts)) {
            return false;
        }
        TbAccounts other = (TbAccounts) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbAccounts[accountId=" + accountId + "]";
    }

}
