/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbRoles")
@NamedQueries({
    @NamedQuery(name = "TbRoles.findAll", query = "SELECT t FROM TbRoles t"),
    @NamedQuery(name = "TbRoles.findByRoleId", query = "SELECT t FROM TbRoles t WHERE t.roleId = :roleId"),
    @NamedQuery(name = "TbRoles.findByRoleName", query = "SELECT t FROM TbRoles t WHERE t.roleName = :roleName")})
public class TbRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Role_Id")
    private String roleId;
    @Basic(optional = false)
    @Column(name = "Role_Name")
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbRoles")
    private Collection<TbAccounts> tbAccountsCollection;

    public TbRoles() {
    }

    public TbRoles(String roleId) {
        this.roleId = roleId;
    }

    public TbRoles(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<TbAccounts> getTbAccountsCollection() {
        return tbAccountsCollection;
    }

    public void setTbAccountsCollection(Collection<TbAccounts> tbAccountsCollection) {
        this.tbAccountsCollection = tbAccountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRoles)) {
            return false;
        }
        TbRoles other = (TbRoles) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbRoles[roleId=" + roleId + "]";
    }

}
