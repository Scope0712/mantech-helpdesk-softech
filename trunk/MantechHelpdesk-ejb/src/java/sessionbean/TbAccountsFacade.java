/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.TbAccounts;

import java.util.List;

import entity.TbDepartments;
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
       try{
         return (TbAccounts) em.createNamedQuery("TbAccounts.findByUsernameAndPassword").setParameter("accountId", username).setParameter("password", password).getSingleResult();
        }
       catch(Exception ex){
            return null;
       }
    }

    @Override
    public TbAccounts findNewAccount() {
        return (TbAccounts) em.createNamedQuery("TbAccounts.findNewAccount").getSingleResult();
       
    }


    public List<TbAccounts> findByRoleAndStatus( String roleId,String status) {
        return (List<TbAccounts>) em.createQuery("SELECT t FROM TbAccounts t WHERE t.status =:status and t.tbRoles.roleId=:roleId").setParameter("status", status).setParameter("roleId", roleId).getResultList();
       // return (List<TbAccounts>) em.createNamedQuery("TbAccounts.findByRoleAndStatus").setParameter("status", status).setParameter("roleId", roleId).getResultList();
    }




    @Override
    public  TbAccounts searchDepartment(TbStaffs staff){
        try{
       return (TbAccounts) em.createNamedQuery("TbAccounts.searchDepartment").setParameter("staff", staff).getSingleResult();
        }
        catch(Exception ex){
         //   ex.printStackTrace();
        return null;
        }
    }

}
