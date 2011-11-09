/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.CountComplaintByCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class CountComplaintByCategoryFacade extends AbstractFacade<CountComplaintByCategory> implements CountComplaintByCategoryFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CountComplaintByCategoryFacade() {
        super(CountComplaintByCategory.class);
    }

}
