/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.ViewAssignTaskDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dell
 */
@Stateless
public class ViewAssignTaskDetailsFacade extends AbstractFacade<ViewAssignTaskDetails> implements ViewAssignTaskDetailsFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViewAssignTaskDetailsFacade() {
        super(ViewAssignTaskDetails.class);
    }

}
