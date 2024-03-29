/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.TbAccounts;


import entity.TbStaffs;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbAccountsFacade extends AbstractFacade<TbAccounts> implements TbAccountsFacadeLocal {

    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbAccountsFacade() {
        super(TbAccounts.class);
    }

    @Override
    public TbAccounts checkUsernamePassword(String username, String password) {
        try {
            return (TbAccounts) em.createQuery("SELECT t FROM TbAccounts t WHERE t.password = :password and t.accountId=:accountId and t.status='Enable'").setParameter("accountId", username).setParameter("password", password).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public TbAccounts findNewAccount() {
        return (TbAccounts) em.createQuery("SELECT t FROM TbAccounts t WHERE t.accountId = (SELECT max(o.accountId) from TbAccounts o)").getSingleResult();

    }

    @Override
    public List<TbAccounts> findByRoleAndStatus(String roleId, String status) {
        return (List<TbAccounts>) em.createQuery("SELECT t FROM TbAccounts t WHERE t.status =:status and t.tbRoles.roleId=:roleId").setParameter("status", status).setParameter("roleId", roleId).getResultList();
        // return (List<TbAccounts>) em.createNamedQuery("TbAccounts.findByRoleAndStatus").setParameter("status", status).setParameter("roleId", roleId).getResultList();
    }

    @Override
    public TbAccounts searchDepartment(TbStaffs staff) {
        try {
            return (TbAccounts) em.createQuery("SELECT t FROM TbAccounts t WHERE t.tbStaffs = :staff and t.status='Enable'").setParameter("staff", staff).getSingleResult();
        } catch (Exception ex) {
           //   ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean unavailableAccount(String accountId) {

        try {
            if (em.createQuery("UPDATE TbAccounts t SET t.status = 'Disable' WHERE t.accountId = :accountId").setParameter("accountId", accountId).executeUpdate() > 0) {
                return true;

            } else {
                return false;
            }
                }
         catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
