/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.CountComplaintByTechnician;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class CountComplaintByTechnicianFacade extends AbstractFacade<CountComplaintByTechnician> implements CountComplaintByTechnicianFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CountComplaintByTechnicianFacade() {
        super(CountComplaintByTechnician.class);
    }

}
