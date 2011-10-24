/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbComplaintLogs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbComplaintLogsFacade extends AbstractFacade<TbComplaintLogs> implements TbComplaintLogsFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbComplaintLogsFacade() {
        super(TbComplaintLogs.class);
    }

}
