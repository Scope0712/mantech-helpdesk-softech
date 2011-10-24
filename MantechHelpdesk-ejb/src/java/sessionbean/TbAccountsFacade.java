/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.TbAccounts;
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
}
