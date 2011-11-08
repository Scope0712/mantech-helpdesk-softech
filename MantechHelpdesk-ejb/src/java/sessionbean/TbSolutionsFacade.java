/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbSolutions;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbSolutionsFacade extends AbstractFacade<TbSolutions> implements TbSolutionsFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbSolutionsFacade() {
        super(TbSolutions.class);
    }

    @Override
    public List<TbSolutions> findAllSolutions() {
        Query q = em.createNativeQuery("SELECT * FROM TbSolutions c where c.Status = 'Enable'", TbSolutions.class);
        return q.getResultList();
    }

}
